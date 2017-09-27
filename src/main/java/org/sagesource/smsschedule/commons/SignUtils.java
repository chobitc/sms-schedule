package org.sagesource.smsschedule.commons;

import sun.misc.BASE64Encoder;

/**
 * <p>加签工具类</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class SignUtils {

	/**
	 * 使用HmacSHA1算法加签
	 *
	 * @param accessSecret
	 * @param stringToSign
	 * @return
	 * @throws Exception
	 */
	public static String signByHmacSHA1(String accessSecret, String stringToSign) throws Exception {
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
		mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes("UTF-8"), "HmacSHA1"));
		byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
		return new BASE64Encoder().encode(signData);
	}

}
