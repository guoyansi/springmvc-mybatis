package com.gys.base.model;

public class JobBase extends PageBase{
	
	private int id;
	private String jobname;//职位名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
}
