package com.gys.job.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.gys.base.dao.DB;
import com.gys.job.model.Job;

@Repository
public class JobDAO {
	private SqlSessionFactory factory;
	public JobDAO(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		DB db=new DB();		
		factory=db.getFactory();
	}
	
	public List<Job> getJobList(Job job){
		SqlSession session=factory.openSession();
		List<Job> list=session.selectList("job.getJobList",job);
		session.close();
		return list;
	}
	
}
