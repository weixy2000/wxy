package org.apache.commons.beanutils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.bean.StudentBean;

/**
 * BeanMap的使用方法
 * 
 * @author wxy
 * 
 */
public class BeanMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentBean bean = new StudentBean();

		String[] majors = new String[] { "1语言", "2计算机", "3经济学" };

		Map friends = new HashMap();
		friends.put("xz", "小张");
		friends.put("xl", "小李");
		friends.put("xw", "小王");

		StudentBean deskmate = new StudentBean();
		deskmate.setId("10011");
		deskmate.setSex("女");
		deskmate.setName("小雪");

		bean.setId("10010");
		bean.setName("张三");
		bean.setSex("男");
		bean.setAge(25);
		bean.setMajors(majors);
		bean.setFriends(friends);
		bean.setDeskmate(deskmate);

		try {
			// 通过Java的内省方式获取JavaBean的相关信息
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			if (propertyDescriptors != null) {
				for (int i = 0; i < propertyDescriptors.length; i++) {
					PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
					if (propertyDescriptor != null) {
						String name = propertyDescriptor.getName();// 属性名称
						Method readMethod = propertyDescriptor.getReadMethod();// getter方法
						Method writeMethod = propertyDescriptor.getWriteMethod();// setter方法
						Class type = propertyDescriptor.getPropertyType();// 属性类型
					}
				}
			}

			// 实例化BeanMap，即使用Java自省方式将JavaBean转换成一个Map类型
			// 以key,value的形式操作JavaBean
			BeanMap beanMap = new BeanMap(bean);

			Object value = beanMap.get("name");// 获取属性name值
			Method readMethod = beanMap.getReadMethod("name");// 获取属性name读取方法
			Method writeMethod = beanMap.getWriteMethod("name");// 获取属性name写入方法
			Class type = beanMap.getType("name");// 获取属性name的类型

			System.out.println(value);
			System.out.println(readMethod);
			System.out.println(writeMethod);
			System.out.println(type);

			// beanMap.containsKey(name)
			// beanMap.containsValue(value);
			// beanMap.entryIterator();
			// beanMap.entrySet();
			// beanMap.isEmpty();
			// beanMap.keyIterator();
			// beanMap.keySet();
			// beanMap.valueIterator();

		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

	}

}
