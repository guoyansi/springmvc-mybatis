package com.gys.sm.fun.demo.bean;

public class Student {
	private Integer stu_id;
	private String stu_name;
	private Integer gd;
	private Integer age;
	private Grade grade;
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	public Integer getGd() {
		return gd;
	}
	public void setGd(Integer gd) {
		this.gd = gd;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
		
	
}
