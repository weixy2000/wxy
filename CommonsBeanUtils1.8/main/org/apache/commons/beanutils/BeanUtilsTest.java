package org.apache.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.bean.StudentBean;

/**
 * BeanUtils的使用方法
 * 
 * @author wxy
 * 
 */
public class BeanUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

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

			// 获取bean的描述信息<prop, value>
			Map map = BeanUtils.describe(bean);
			for (Object key : map.keySet()) {
				System.out.println("prop=" + key + ",value=" + map.get(key));
			}

			// 获取有下标类型属性的值：如数组、List
			System.out.println(BeanUtils.getIndexedProperty(bean, "majors[1]"));
			System.out.println(BeanUtils.getIndexedProperty(bean, "majors", 1));
			// 获取有键、值类型属性的值：如Map
			System.out.println(BeanUtils.getMappedProperty(bean, "friends(xl)"));
			System.out.println(BeanUtils.getMappedProperty(bean, "friends", "xl"));
			// 获取嵌套属性的值
			System.out.println(BeanUtils.getNestedProperty(bean, "deskmate.name"));
			// 获取任意属性的值
			System.out.println(BeanUtils.getProperty(bean, "sex"));
			// 获取简单属性的值(8个简单属性)
			System.out.println(BeanUtils.getSimpleProperty(bean, "age"));
			// 获取数组属性的值
			String majors1[] = BeanUtils.getArrayProperty(bean, "majors");
			for (int i = 0; i < majors1.length; i++) {
				if (i > 0) {
					System.out.print("，");
				}
				System.out.print(majors1[i]);
			}
			System.out.println();
			// 克隆JavaBean
			StudentBean orig = (StudentBean) BeanUtils.cloneBean(bean);
			System.out.println(orig.getName());

			StudentBean dest = new StudentBean();
			// 复制JavaBean属性值：源和目标为以下类型：DynaBean、Map或JavaBean
			BeanUtils.copyProperties(dest, orig);
			System.out.println(dest.getDeskmate().getName());

			// 给指定属性赋值
			BeanUtils.copyProperty(bean, "name", "张三NEW");
			System.out.println(bean.getName());

			// 给指定属性赋值(推荐使用copyProperty()方法赋值)
			BeanUtils.setProperty(bean, "name", "张三VERY NEW");
			System.out.println(bean.getName());

			Map properties = new HashMap();
			properties.put("id", "10012");
			properties.put("name", "张哈");
			properties.put("sex", "男");
			// 使用Map<prop, value>给JavaBean赋值
			BeanUtils.populate(bean, properties);
			System.out.println(bean.getName());

			StudentBean stuBean = new StudentBean();
			// 使用Map<prop, value>给JavaBean赋值
			BeanUtils.copyProperties(stuBean, properties);
			System.out.println(stuBean.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
