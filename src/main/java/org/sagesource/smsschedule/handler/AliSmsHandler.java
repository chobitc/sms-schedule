package org.sagesource.smsschedule.handler;

import org.sagesource.smsschedule.thirdservice.alisms.AliSmsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>阿里渠道的处理Handler</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Component("aliSmsHandler")
public class AliSmsHandler extends BaseHandler {

	@Autowired
	private AliSmsWrapper aliSmsWrapper;

	@Override
	public void sendMessage(String phoneNumber, String signName, String templateParam, String templateCode) throws Exception {
		AliSmsWrapper.SendConfig sendConfig = new AliSmsWrapper.SendConfig();
		sendConfig.setPhoneNumber(phoneNumber);
		sendConfig.setSignName(signName);
		sendConfig.setTemplateCode(templateCode);
		sendConfig.setTemplateParam(templateParam);

		aliSmsWrapper.send(sendConfig);
	}
}
