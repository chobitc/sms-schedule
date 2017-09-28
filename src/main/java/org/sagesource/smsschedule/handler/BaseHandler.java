package org.sagesource.smsschedule.handler;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public abstract class BaseHandler {

	/**
	 * 发送短信
	 *
	 * @param phoneNumber   手机号
	 * @param signName      签名
	 * @param templateParam 模板参数
	 * @param templateCode  模板编号
	 */
	public abstract void sendMessage(String phoneNumber, String signName, String templateParam, String templateCode) throws Exception;

}
