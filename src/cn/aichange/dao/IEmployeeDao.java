package cn.aichange.dao;

import java.io.Serializable;

import cn.aichange.bean.Employee;

public interface IEmployeeDao extends IBaseDao<Employee> {
	/**
	 * 删除dept时，需要检查该部门下有无员工
	 * @param id	dept_id
	 * @return	true:有员工，不能删；false：无员工，可以删
	 */
	public boolean findByDeptId(Serializable id);
}
