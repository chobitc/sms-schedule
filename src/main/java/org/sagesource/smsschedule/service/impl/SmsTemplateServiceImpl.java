package org.sagesource.smsschedule.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.sagesource.smsschedule.commons.values.CacheKey;
import org.sagesource.smsschedule.entity.SmsTemplateInfoEntity;
import org.sagesource.smsschedule.service.SmsTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       sage.xue@vipshop.com
 * </pre>
 */
@Service
public class SmsTemplateServiceImpl implements SmsTemplateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsTemplateServiceImpl.class);

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void saveTemplate(SmsTemplateInfoEntity smsTemplateInfo) {
		SessionCallback sessionCallback = new SessionCallback() {
			@Override
			public Object execute(RedisOperations operations) throws DataAccessException {
				// 在事务中的操作返回都是null,因此不能在execute中对操作的结果进行处理 例如get等
				Object templateList = operations.opsForHash().get(CacheKey.SMS_CHANNEL_TEMPLATE, smsTemplateInfo.getTemplateType());

				operations.multi();
				List<SmsTemplateInfoEntity> resultList = null;
				if (templateList == null) {
					resultList = new LinkedList<>();
				} else {
					resultList = JSONObject.parseObject(templateList.toString(), LinkedList.class);
				}
				resultList.add(smsTemplateInfo);
				operations.opsForHash().put(CacheKey.SMS_CHANNEL_TEMPLATE, smsTemplateInfo.getTemplateType(), JSON.toJSONString(resultList));

				return operations.exec();
			}
		};
		redisTemplate.execute(sessionCallback);
	}
}
