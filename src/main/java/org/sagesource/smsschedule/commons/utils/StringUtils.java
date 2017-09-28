package org.sagesource.smsschedule.commons.utils;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class StringUtils {

	/**
	 * URL字符串编码
	 *
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String specialUrlEncode(String value) throws Exception {
		return java.net.URLEncoder.encode(value, "UTF-8")
				.replace("+", "%20")
				.replace("*", "%2A")
				.replace("%7E", "~");
	}

}
