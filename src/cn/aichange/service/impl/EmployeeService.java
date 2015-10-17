package cn.aichange.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.aichange.bean.Employee;
import cn.aichange.dao.IEmployeeDao;
import cn.aichange.service.IEmployeeService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

public class EmployeeService implements IEmployeeService {
	//注入dao
	private IEmployeeDao employeeDao;
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	public Employee findById(Serializable id) {
		return employeeDao.findById(id);
	}

	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	public void delete(Serializable id) {
		employeeDao.delete(id);
	}

	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	
	@Deprecated
	public List<Employee> findByPage(int index, int count) {
		return employeeDao.findByPage(index, count);
	}
	
	@Deprecated
	public Long findTotalCount() {
		return employeeDao.findTotalCount();
	}


	public boolean findByDeptId(Serializable id) {
		return employeeDao.findByDeptId(id);
	}


	public PageBean<Employee> findPageByCondition(Condition condition,
			int currentPage, int pageSize) {
		//0.判断
		if(condition == null){
			condition = new Condition();
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		if(pageSize == 0){
			pageSize = 6;
		}
		
		//1.组装hql，同时封装参数列表
		StringBuffer hql = new StringBuffer(" where 1=1 ");
		List<Object> values = new ArrayList<Object>();
		if(StringUtils.isNotBlank(condition.getName())){
			hql.append(" and empName like ? ");
			values.add("%"+condition.getName()+"%");
		}
		if(StringUtils.isNotBlank(condition.getPhone())){
			hql.append(" and phone like ? ");
			values.add("%"+condition.getPhone()+"%");
		}
		if(StringUtils.isNotBlank(condition.getEmail())){
			hql.append(" and email like ? ");
			values.add(condition.getEmail());
		}
		if((condition.getDeptId() != null) && (condition.getDeptId() != -1)){
			hql.append(" and dept_id = ? ");
			values.add(condition.getDeptId());
		}

		String hql_page = "from Employee " + hql.toString();
		String hql_count = "select count(*) from Employee " + hql.toString();
		
		//2.计算index,count
		int index = (currentPage - 1) * pageSize;
		int count = pageSize;
		
		//3.调用dao方法
		List<Employee> pageData = employeeDao.findPageByCondition(hql_page, values, index, count);
		Long totalCountLong = employeeDao.findTotalCountByCondition(hql_count, values);
		int totalCount = totalCountLong.intValue();
		
		//4.设置PageBean的值，返回
		int totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageData(pageData);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		
		return pageBean;
	}

	public List<Employee> findByCondition(Condition condition) {
		String hql = "from Employee where empName=? and pwd=? ";
		String empName = condition.getName();
		String pwd = condition.getPwd();
		List<Employee> list = employeeDao.findByCondition(hql, empName, pwd);
		return list;
	}
	
	
	public List<Employee> findByNotId(Serializable id) {
		String hql = "from Employee where id != ?";
		List<Employee> list = employeeDao.findByCondition(hql, id);
		return list;
	}

}
