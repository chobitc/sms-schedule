package org.sagesource.smsschedule.service;

import org.sagesource.smsschedule.entity.SmsChannelInfoEntity;

/**
 * <p>短信渠道Service</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public interface SmsChannelService {

	/**
	 * 保存短信渠道
	 *
	 * @param smsChannelInfo
	 */
	boolean saveChannel(SmsChannelInfoEntity smsChannelInfo);

}
