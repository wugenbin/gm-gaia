package com.ntc.gaia.base.utils.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * List 帮助类
 * 
 * @author Allen
 * @time 2012-07-24
 * 
 */
public class ListUtils {

	/**
	 * 判断List为Null 或者为空
	 * 
	 * @param list
	 * @return
	 */
	public static boolean empty(List<?> list) {

		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 判断List不为NULL
	 * 
	 * @param list
	 * @return
	 */

	public static boolean notEmpty(List<?> list) {
		return !empty(list);
	}

	/**
	 * 将数组转换为一个List，实际上是一个ArrayList。
	 * 
	 * @param <T>
	 * 
	 * @param array
	 *            原数组
	 * @return 原数组不为null的时候返回包含数组内容的ArrayList，否则返回null
	 * @since 0.5
	 * @deprecated 在实现的时候没有注意到java.util.Arrays类中有一个方法asList(Object[] a)，
	 *             请使用该方法替换本方法。
	 */

	@SuppressWarnings("unchecked")
	public static <T> List<T> ArrayToList(Object[] array) {
		if (array != null) {

			List<T> list = new ArrayList<T>(array.length);
			for (int i = 0; i < array.length; i++) {
				list.add(((T) array[i]));
			}
			return list;
		} else {
			return new ArrayList<T>();
		}
	}

	/**
	 * 将数组中的内容全部添加到列表中。
	 * 
	 * @param <T>
	 * 
	 * @param array
	 *            数组
	 * @param list
	 *            列表
	 * @since 0.5
	 */

	@SuppressWarnings("unchecked")
	public static <T> void addArrayToList(Object[] array, List<T> list) {
		if (array == null || list == null || array.length == 0) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			list.add(((T) array[i]));
		}
	}

	/**
	 * 将数组中的内容全部添加到列表中。
	 * 
	 * @param <T>
	 * 
	 * @param array
	 *            数组
	 * @param list
	 *            列表
	 * @param start
	 *            开始位置
	 * @since 0.5
	 */

	@SuppressWarnings("unchecked")
	public static <T> void addArrayToList(Object[] array, List<T> list, int start) {
		if (array == null || list == null || array.length == 0) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			list.add(start + i, ((T) array[i]));
		}
	}

	/**
	 * 移动列表中的元素。
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            列表
	 * @param start
	 *            移动的元素的开始索引
	 * @param end
	 *            移动的元素的最后索引，不包括这个
	 * @param to
	 *            移动到的位置
	 * @since 0.5
	 */

	public static <T> void moveElements(List<T> list, int start, int end, int to) {
		List<T> subList = new ArrayList<T>(list.subList(start, end));
		list.removeAll(subList);
		list.addAll(to, subList);
	}

	/**
	 * List大数据量，进行分割
	 * 
	 * @param <T>
	 * @param length
	 *            单个list最大长度
	 * @param paramsList
	 *            参数源列表
	 * @return
	 */
	public static <T> List<List<T>> splitInParams(int length, List<T> paramsList) {

		if (length < 1 || paramsList == null || paramsList.size() == 0) {
			return new ArrayList<List<T>>();
		}
		int listSize = paramsList.size();
		List<List<T>> splitList = new ArrayList<List<T>>();
		int splitNumber = (int) Math.ceil(listSize / (length + 0.0));
		for (int index = 0; index < splitNumber; index++) {
			int fromIndex = length * index;
			int toIndex = Math.min(fromIndex + length, listSize);
			splitList.add(paramsList.subList(fromIndex, toIndex));
		}
		return splitList;
	}

	/**
	 * List 按对象属性排序
	 * 
	 * @param list
	 *            排序List集合
	 * @param method
	 *            list对象属性的getter方法(不含"()",如"getUsername");
	 * @param sort
	 *            排序类型 (desc:倒序,asc或者null为正序)
	 * 
	 */

	public static <T> void sort(List<T> list, final String method, final String sort) {
		if (empty(list) || StringUtil.empty(method)) {
			return;
		}

		Collections.sort(list, new Comparator<T>() {

			public int compare(Object a, Object b) {

				int rc = 0;
				try {
					Method m1 = a.getClass().getMethod(method);
					Method m2 = a.getClass().getMethod(method);

					if (sort != null && ("desc".equals(sort))) {
						// 倒序
						rc = m2.invoke(b).toString().compareTo(m1.invoke(a).toString());
					} else {
						// 正序
						rc = m1.invoke(a).toString().compareTo(m2.invoke(b).toString());
					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				return rc;
			}

		});
	}
}
