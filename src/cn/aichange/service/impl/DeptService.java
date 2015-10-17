package cn.aichange.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.aichange.bean.Dept;
import cn.aichange.dao.IDeptDao;
import cn.aichange.service.IDeptService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

public class DeptService implements IDeptService {
	//从IOC获取对象
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

	public Dept findById(Serializable id) {
		return deptDao.findById(id);
	}

	public void save(Dept dept) {
		deptDao.save(dept);
	}

	public void delete(Serializable id) {
		deptDao.delete(id);
	}

	public void update(Dept dept) {
		deptDao.update(dept);
	}

	public List<Dept> findByPage(int index, int count) {
		return deptDao.findByPage(index, count);
	}

	public Long findTotalCount() {
		return deptDao.findTotalCount();
	}


	public PageBean<Dept> findPageByCondition(Condition condition,
			int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Dept> findByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
