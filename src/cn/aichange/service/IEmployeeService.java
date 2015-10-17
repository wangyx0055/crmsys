package cn.aichange.service;

import java.io.Serializable;
import java.util.List;

import cn.aichange.bean.Employee;

public interface IEmployeeService extends IBaseService<Employee> {
	/**
	 * 删除dept时，需要检查该部门下有无员工
	 * @param id	dept_id
	 * @return	true:有员工，不能删；false：无员工，可以删
	 */
	public boolean findByDeptId(Serializable id);
	
	/**
	 * 移交时，接收者不能为当前登录员工
	 * @param id	当前登录员工
	 * @return	除当前登录员工外的所有员工
	 */
	public List<Employee> findByNotId(Serializable id);
}
