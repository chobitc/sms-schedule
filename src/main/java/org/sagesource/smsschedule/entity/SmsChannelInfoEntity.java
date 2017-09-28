package org.sagesource.smsschedule.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>短信渠道信息实体</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class SmsChannelInfoEntity implements Serializable {
	private static final long serialVersionUID = -8982590742698956883L;

	/**
	 * 渠道名称
	 */
	private String channelName;
	/**
	 * 渠道状态 0 - 无效; 1 - 有效(默认)
	 */
	private int status = 1;
	/**
	 * 渠道连接处理器名称
	 */
	private String handlerName;
	/**
	 * 优先级
	 */
	private int    priority;
	/**
	 * 创建时间
	 */
	private Date   createTime;
	/**
	 * 更新时间
	 */
	private Date   updateTime;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
