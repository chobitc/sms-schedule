package org.sagesource.smsschedule.service;

import org.junit.Test;
import org.sagesource.smsschedule.SmsScheduleApplicationTests;
import org.sagesource.smsschedule.entity.SmsTemplateInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class SmsTemplateServiceTest extends SmsScheduleApplicationTests {

	@Autowired
	private SmsTemplateService smsTemplateService;

	@Test
	public void saveTemplateTest() {
		SmsTemplateInfoEntity smsTemplateInfoEntity = new SmsTemplateInfoEntity();
		smsTemplateInfoEntity.setChannelName("ali_sms");
		smsTemplateInfoEntity.setTemplateType("daily_notify");
		smsTemplateInfoEntity.setTemplateCode("111");

		smsTemplateService.saveTemplate(smsTemplateInfoEntity);
	}

}
