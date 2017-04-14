package com.svili.crud.mybatis.common;

import java.util.Collection;

/**
 * 字符串工具类
 * 
 * @author svili
 * @date 2016年11月8日
 *
 */
public class StringUtil {

	/**
	 * 将驼峰标识转换为下划线
	 * 
	 * @param text
	 * @return camel
	 */
	public static String camelToUnderline(String text) {
		if (text == null || "".equals(text.trim())) {
			return "";
		}
		StringBuffer result = new StringBuffer(text.length() + 1);
		result.append(text.substring(0, 1));
		for (int i = 1; i < text.length(); i++) {
			if (!Character.isLowerCase(text.charAt(i))) {
				result.append('_');
			}
			result.append(text.substring(i, i + 1));
		}
		return result.toString().toLowerCase();
	}

	/**
	 * 将下划线标识转换为驼峰
	 * 
	 * @param text
	 * @return underline
	 */
	public static String underlineToCamel(String text) {
		if (text == null || "".equals(text.trim())) {
			return "";
		}
		int length = text.length();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char c = text.charAt(i);
			if (c == '_') {
				if (++i < length) {
					result.append(Character.toUpperCase(text.charAt(i)));
				}
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	/**
	 * 将集合用逗号","分割
	 * 
	 * @param collection
	 *            集合
	 * @return string
	 */
	public static String splitCollectionByComma(Collection<?> collection) {
		StringBuffer result = new StringBuffer();
		for (Object obj : collection) {
			result.append(",").append(obj.toString());
		}
		return result.substring(1, result.length());
	}

}
