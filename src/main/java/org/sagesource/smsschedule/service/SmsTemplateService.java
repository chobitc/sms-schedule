package org.sagesource.smsschedule.service;

import org.sagesource.smsschedule.entity.SmsTemplateInfoEntity;

/**
 * <p>短信模板Service</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public interface SmsTemplateService {

	/**
	 * 保存短信模板
	 *
	 * @param smsTemplateInfo
	 */
	void saveTemplate(SmsTemplateInfoEntity smsTemplateInfo);

}
