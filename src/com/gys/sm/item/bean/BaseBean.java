package com.gys.sm.item.bean;


public class BaseBean {
	//数据起始索引
	private Integer index=0;
	//数据起始索引(根据pageSize和currentPage计算得来)
	@SuppressWarnings("unused")
	private Integer pageStart;
	//结束索引
	@SuppressWarnings("unused")
	private Integer pageEnd;
	//当前页
	private Integer currentPage=1;
	//一共多少页
	private Integer pageCount=0;
	//一共多少行
	private Integer rsCount;
	//每页多少条数据[默认10条]
	private Integer pageSize=10;
	//创建时间
	private String create_time;
	//创建人
	private String create_user;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getPageStart() {
		return (this.currentPage-1)*this.pageSize;
	}
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
	public Integer getPageEnd() {
		return this.currentPage*this.pageSize;
	}
	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getRsCount() {
		return rsCount;
	}
	public void setRsCount(Integer rsCount) {
		this.rsCount = rsCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	
	
}
