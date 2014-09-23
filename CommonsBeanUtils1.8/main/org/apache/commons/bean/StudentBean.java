package org.apache.commons.bean;

import java.util.Map;

public class StudentBean {

	private String id;// 学号
	private String name;// 姓名
	private String sex;// 性别
	private int age;// 年龄
	private String[] majors;// 所学专业
	private Map friends;// 朋友
	private StudentBean deskmate;// 同桌

	public StudentBean() {
	}

	public StudentBean(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getMajors() {
		return majors;
	}

	public void setMajors(String[] majors) {
		this.majors = majors;
	}

	public Map getFriends() {
		return friends;
	}

	public void setFriends(Map friends) {
		this.friends = friends;
	}

	public StudentBean getDeskmate() {
		return deskmate;
	}

	public void setDeskmate(StudentBean deskmate) {
		this.deskmate = deskmate;
	}

}
