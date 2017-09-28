package org.sagesource.smsschedule.controller;

import com.alibaba.fastjson.JSONObject;
import org.sagesource.smsschedule.entity.SmsChannelInfoEntity;
import org.sagesource.smsschedule.service.SmsChannelService;
import org.sagesource.smsschedule.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>短信通道Controller</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@RestController
@RequestMapping(value = "/sms/channel", produces = {"application/json;charset=utf8"})
public class SmsChannelController {

	@Autowired
	private SmsChannelService smsChannelService;

	/**
	 * 保存渠道信息对象
	 *
	 * @param requestBody <ul>
	 *                    <li>smsName:渠道名称(系统唯一)</li>
	 *                    <li>handlerName:渠道处理器名称(系统存在)</li>
	 *                    <li>priority:优先级</li>
	 *                    </ul>
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = {"application/json"})
	public ResponseResult add(@RequestBody String requestBody) {
		SmsChannelInfoEntity smsChannelInfoEntity = JSONObject.parseObject(requestBody, SmsChannelInfoEntity.class);
		smsChannelService.saveChannel(smsChannelInfoEntity);
		return ResponseResult.success();
	}
}
