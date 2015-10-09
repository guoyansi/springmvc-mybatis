package com.gys.test;

import java.util.List;

import com.gys.job.dao.JobDAO;
import com.gys.job.model.Job;

public class Test {
	public static void main(String[] args) {
		JobDAO jobDAO=new JobDAO();
		Job job=new Job();
		job.setId(2);
		List<Job> list=jobDAO.getJobList(job);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getJobname());
		}
	}
}
