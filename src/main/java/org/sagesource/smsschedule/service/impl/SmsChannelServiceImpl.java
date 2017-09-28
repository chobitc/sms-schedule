package org.sagesource.smsschedule.service.impl;

import com.alibaba.fastjson.JSON;
import org.sagesource.smsschedule.commons.values.CacheKey;
import org.sagesource.smsschedule.entity.SmsChannelInfoEntity;
import org.sagesource.smsschedule.service.SmsChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Service
public class SmsChannelServiceImpl implements SmsChannelService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsChannelServiceImpl.class);

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean saveChannel(SmsChannelInfoEntity smsChannelInfo) {
		if (smsChannelInfo != null) {
			if (smsChannelInfo.getCreateTime() == null) {
				Date date = new Date();
				smsChannelInfo.setCreateTime(date);
				smsChannelInfo.setUpdateTime(date);
			}
			Boolean result = redisTemplate.opsForHash().putIfAbsent(CacheKey.SMS_CHANNEL_LIST,
					smsChannelInfo.getChannelName(), JSON.toJSONString(smsChannelInfo));
			LOGGER.info("[saveChannel]保存短信渠道 | smsChannelInfo=[{}] | Result=[{}]", JSON.toJSONString(smsChannelInfo), result);
			return result;
		}
		return false;
	}
}
