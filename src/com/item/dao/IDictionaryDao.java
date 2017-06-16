package com.item.dao;

import java.util.List;

import com.item.bean.DictionaryBean;

public interface IDictionaryDao {
	/**
	 * 获取字典表所有数据
	 * @return
	 * @throws Exception
	 */
	List<DictionaryBean> getDictionaryList() throws Exception;
}
