package cn.aichange.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import cn.aichange.bean.Employee;
import cn.aichange.dao.IEmployeeDao;

public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao{

	public boolean findByDeptId(Serializable id) {
		Query q = getSession().createQuery("select count(id) from Employee where dept_id=?");
		q.setParameter(0, id);
		Long count = (Long)q.uniqueResult();
		if(count.intValue() != 0){
			return true;
		}else{
			return false;
		}
	}
}
