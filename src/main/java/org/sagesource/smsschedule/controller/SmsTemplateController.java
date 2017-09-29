package org.sagesource.smsschedule.controller;

import com.alibaba.fastjson.JSONObject;
import org.sagesource.smsschedule.entity.SmsTemplateInfoEntity;
import org.sagesource.smsschedule.service.SmsTemplateService;
import org.sagesource.smsschedule.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>短信模板操作Controller</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/29
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@RestController
@RequestMapping(value = "/sms/template", produces = {"application/json;charset=utf8"})
public class SmsTemplateController {

	@Autowired
	private SmsTemplateService smsTemplateService;

	/**
	 * 添加短信模板
	 *
	 * @param requestBody <ul>
	 *                    <li>templateType:模板类型</li>
	 *                    <li>channelName:渠道名称</li>
	 *                    <li>templateCode:短信模板在渠道的编号</li>
	 *                    <li>templateSign:短信模板在渠道的签名</li>
	 *                    <li>templatePara:短信模板参数列表 '|' 分割</li>
	 *                    </ul>
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = {"application/json"})
	public ResponseResult add(@RequestBody String requestBody) {
		SmsTemplateInfoEntity templateInfo = JSONObject.parseObject(requestBody, SmsTemplateInfoEntity.class);
		smsTemplateService.saveTemplate(templateInfo);
		return ResponseResult.success();
	}
}
