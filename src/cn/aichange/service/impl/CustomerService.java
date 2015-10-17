package cn.aichange.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.aichange.bean.Customer;
import cn.aichange.dao.ICustomerDao;
import cn.aichange.service.ICustomerService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

public class CustomerService implements ICustomerService {
	//从IOC获取对象
	private ICustomerDao customerDao;
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findById(Serializable id) {
		return customerDao.findById(id);
	}

	public void save(Customer customer) {
		customerDao.save(customer);
	}

	public void delete(Serializable id) {
		customerDao.delete(id);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}
	
	@Deprecated
	public List<Customer> findByPage(int index, int count) {
		return customerDao.findByPage(index, count);
	}
	
	@Deprecated
	public Long findTotalCount() {
		return customerDao.findTotalCount();
	}


	public PageBean<Customer> findPageByCondition(Condition condition,
			int currentPage, int pageSize) {
		//1.判断
		/*
		if(condition == null){
			condition = new Condition();
		}
		*/
		
		//如果是第一次访问，设置默认当前页为第一页
		if(currentPage == 0){
			currentPage = 1;
		}
		
		//如果是第一次访问，设置默认每页显示5条记录
		if(pageSize == 0){
			pageSize = 6;
		}
		
		
		
		//2.拼装hql,同时封装参数列表
		StringBuffer hql = new StringBuffer("where 1=1 ");
		List<Object> values = new ArrayList<Object>();
		if(StringUtils.isNotBlank(condition.getName())){
			hql.append(" and name like ? ");
			values.add("%"+condition.getName()+"%");
		}
		if(StringUtils.isNotBlank(condition.getPhone())){
			hql.append(" and telphone=? ");
			values.add("%"+condition.getPhone()+"%");
		}
		if(StringUtils.isNotBlank(condition.getAddress())){
			hql.append(" and address like ? ");
			values.add("%"+condition.getAddress()+"%");
		}
		if(StringUtils.isNotBlank(condition.getEmail())){
			hql.append(" and email=? ");
			values.add(condition.getEmail());
		}
		//客户管理中，traceStatus=0,资源池中，traceStatus=-1
		if(StringUtils.isNotBlank(condition.getTraceStatus().toString())){
			hql.append(" and trace_status=? ");
			values.add(condition.getTraceStatus());
		}
		
		String hql_page = "from Customer "+hql.toString();
		String hql_count = "select count(id) from Customer "+hql.toString();
		
		//3.计算index,count
		int index = (currentPage - 1) * pageSize;
		int count = pageSize;
		
		//4.调用dao两个查询方法		
		List<Customer> pageData = customerDao.findPageByCondition(hql_page, values, index, count);
		Long totalCountLong = customerDao.findTotalCountByCondition(hql_count, values);
		int totalCount = totalCountLong.intValue();
		
		//5.封装PageBean，返回
		int totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageData(pageData);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}


	public List<Customer> findByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
