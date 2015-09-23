package com.gys.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gys.job.dao.JobDAO;
import com.gys.job.model.Job;

public class Test {
	public static void main(String[] args) {
		JobDAO jobDAO=new JobDAO();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", 2);
		List<Job> list=jobDAO.getJobList(map);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getJobname());
		}
	}
}
