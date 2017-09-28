package org.sagesource.smsschedule.service;

import org.junit.Test;
import org.sagesource.smsschedule.SmsScheduleApplicationTests;
import org.sagesource.smsschedule.entity.SmsChannelInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email      job.xueqi@gmail.com
 * </pre>
 */
public class SmsChannelServiceTest extends SmsScheduleApplicationTests {

	@Autowired
	private SmsChannelService smsChannelService;

	@Test
	public void saveChannelTest() {
		SmsChannelInfoEntity smsChannelInfoEntity = new SmsChannelInfoEntity();
		smsChannelInfoEntity.setChannelName("ali_sms");
		smsChannelService.saveChannel(smsChannelInfoEntity);
	}

}
