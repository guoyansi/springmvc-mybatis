package com.gys.sm.item.dao;

import java.util.List;

import com.gys.sm.item.bean.SysDictionaryBean;


public interface ISysDictionaryDao {
	/**
	 * 获取字典表所有数据
	 * @return
	 * @throws Exception
	 */
	List<SysDictionaryBean> getDictionaryList() throws Exception;
}
