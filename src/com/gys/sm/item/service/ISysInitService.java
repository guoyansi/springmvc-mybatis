package com.gys.sm.item.service;

import java.util.List;

import com.gys.sm.item.bean.SysDictionaryBean;

public interface ISysInitService {
	/**
	 * 获取字典表
	 * @return
	 */
	List<SysDictionaryBean> getDictionaryList() throws Exception;
}
