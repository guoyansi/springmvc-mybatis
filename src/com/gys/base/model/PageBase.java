package com.gys.base.model;

public class PageBase {
	private int pageSize;//每页显示多少条
	private int totalCount;//总数量条数
	private int currentPage;//当前页
	private int startIndex;//数据开始索引
	
	
	private String message;//操作结果
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int pageSize,int currentPage) {
		this.startIndex = pageSize*(currentPage-1);
	}
}
