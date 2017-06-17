package com.gys.sm.item.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gys.sm.item.bean.SysDictionaryBean;
import com.gys.sm.item.dao.ISysDictionaryDao;
import com.gys.sm.item.service.ISysInitService;

@Service
public class SysInitServiceImpl implements ISysInitService{

	@Autowired
	private ISysDictionaryDao iSysDictionaryDao;
	@Override
	public List<SysDictionaryBean> getDictionaryList() throws Exception{
		return iSysDictionaryDao.getDictionaryList();
	}
	
}
