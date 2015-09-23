package com.gys.job.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gys.job.model.Job;
import com.gys.job.service.JobService;

@Controller
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping("/list")
	public void getJobList(){
		Map<String, Object> map=new HashMap<String, Object>();
		/*List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);*/
		map.put("id", 1);
		List<Job> list=jobService.getJobList(map);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getJobname());
		}
	}
	
}
