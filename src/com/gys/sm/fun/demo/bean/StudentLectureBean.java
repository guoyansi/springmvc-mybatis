package com.gys.sm.fun.demo.bean;

import java.math.BigDecimal;

/**
 * 课程成绩表
 * @author Administrator
 *
 */
public class StudentLectureBean {
	private Integer id;
	private Integer student_id;
	private LectureBean lecture;
	private BigDecimal grade;
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public LectureBean getLecture() {
		return lecture;
	}
	public void setLecture(LectureBean lecture) {
		this.lecture = lecture;
	}
	public BigDecimal getGrade() {
		return grade;
	}
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
