package cn.aichange.util;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
	//封装分页相关数据
	private int currentPage;		//当前页
	private int pageSize;			//每页显示记录数
	private int totalCount;			//总记录数
	private int totalPage;			//总页数
	private int prePage;			//上一页
	private int nextPage;			//下一页
	private List<T> pageData;		//页面数据
	
	//获取总页数，由于nextPage的获取需要用到totalPage，因此这里应该在service层先计算出来。
	public int getTotalPage() {
		return totalPage;
	}
	
	//获取上一页
	public int getPrePage() {
		return (currentPage > 1) ? (currentPage - 1) : (currentPage);
	}
	
	//获取下一页
	public int getNextPage() {
		return (currentPage < totalPage) ? (currentPage + 1) : (currentPage);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
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
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	
}














