package com.gys.job.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gys.job.dao.JobDAO;
import com.gys.job.model.Job;

@Service
@Component
public class JobService {
	@Autowired
	private JobDAO jobDAO;
	
	public List<Job> getJobList(Map<String, Object> map){
		return jobDAO.getJobList(map);
	}
	
}
