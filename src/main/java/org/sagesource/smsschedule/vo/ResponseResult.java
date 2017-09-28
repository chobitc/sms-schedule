package org.sagesource.smsschedule.vo;

/**
 * <p>响应结果</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class ResponseResult {
	/**
	 * 响应码
	 */
	private String code    = "200";
	/**
	 * 响应消息
	 */
	private String message = "OK";
	/**
	 * 响应内容
	 */
	private Object response;

	/**
	 * 响应成功
	 *
	 * @return
	 */
	public static ResponseResult success() {
		ResponseResult responseResult = new ResponseResult();
		return responseResult;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getResponse() {
		return response;
	}
}
