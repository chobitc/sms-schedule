package org.sagesource.smsschedule.commons.utils;

import com.alibaba.fastjson.JSON;

import java.util.TreeMap;

/**
 * <p>对象操作类</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class ObjectUtils {

	/**
	 * 将对象转换为按字段排序的TreeMap
	 *
	 * @param object
	 * @return
	 */
	public static TreeMap<String, Object> convertToTreeMap(Object object) {
		String tempJson = JSON.toJSONString(object);
		return JSON.parseObject(tempJson, TreeMap.class);
	}

}
