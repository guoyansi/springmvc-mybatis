package com.gys.sm.item.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gys.sm.item.bean.SysDictionaryBean;

@Repository
public interface ISysDictionaryDao {
	/**
	 * 获取字典表所有数据
	 * @return
	 * @throws Exception
	 */
	List<SysDictionaryBean> getDictionaryList() throws Exception;
}
