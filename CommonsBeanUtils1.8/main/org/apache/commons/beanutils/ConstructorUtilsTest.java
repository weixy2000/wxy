package org.apache.commons.beanutils;

import java.lang.reflect.Constructor;

import org.apache.commons.bean.StudentBean;

/**
 * ConstructorUtils的使用方法
 * 
 * @author wxy
 */
public class ConstructorUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Integer.TYPE 参数类型为int
//		Integer.class 参数类型为java.lang.Integer
		
		StudentBean bean = new StudentBean();
		try {
			Constructor ctor = bean.getClass().getConstructor();
			// 返回给定构造函数是否能访问
			Constructor ctor1 = ConstructorUtils.getAccessibleConstructor(ctor);
			System.out.println(ctor1);
			// 返回使用一个指定参数类型的构造函数
			Constructor ctor2 = ConstructorUtils.getAccessibleConstructor(bean.getClass(), Integer.TYPE);
			System.out.println(ctor2);
			// 返回给定class和参数数组的构造函数
			Constructor ctor3 = ConstructorUtils.getAccessibleConstructor(bean.getClass(), new Class[]{});
			System.out.println(ctor3);
			
			// 以下方法：对参数的要求不是太严格 int或java.lang.Integer都行
			// 根据给定的class和值执行对应的构造函数
			StudentBean bean1 = (StudentBean) ConstructorUtils.invokeConstructor(bean.getClass(), 1);
			System.out.println(bean1.getAge());
			// 根据给定的class和多个值执行对应的构造函数
			StudentBean bean2 = (StudentBean) ConstructorUtils.invokeConstructor(bean.getClass(), new Object[]{2});
			System.out.println(bean2.getAge());
			// 根据给定的class和多个值及值对应的类型执行对应的构造函数
			StudentBean bean3 = (StudentBean) ConstructorUtils.invokeConstructor(bean.getClass(), new Object[]{3}, new Class[]{Integer.TYPE});
			System.out.println(bean3.getAge());
			
			// 以下方法：参数要求更加严格，传递进去的参数必须严格符合构造方法的参数列表
			// 报错，解析为java.lang.Integer
//			StudentBean bean4 = (StudentBean) ConstructorUtils.invokeExactConstructor(bean.getClass(), 1);
//			System.out.println(bean4.getAge());
//			StudentBean bean5 = (StudentBean) ConstructorUtils.invokeExactConstructor(bean.getClass(), new Object[]{2});
//			System.out.println(bean5.getAge());
			StudentBean bean6 = (StudentBean) ConstructorUtils.invokeExactConstructor(bean.getClass(), new Object[]{3}, new Class[]{Integer.TYPE});
			System.out.println(bean6.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
