package cn.aichange.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.aichange.bean.Employee;
import cn.aichange.bean.TraceHistory;
import cn.aichange.dao.ITraceHistoryDao;
import cn.aichange.service.ITraceHistoryService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

public class TraceHistoryService implements ITraceHistoryService {
	//注入dao
	private ITraceHistoryDao traceHistoryDao;
	public void setTraceHistoryDao(ITraceHistoryDao traceHistoryDao) {
		this.traceHistoryDao = traceHistoryDao;
	}
	
	
	public List<TraceHistory> findAll() {
		return traceHistoryDao.findAll();
	}

	public TraceHistory findById(Serializable id) {

		return null;
	}

	public void save(TraceHistory t) {
		traceHistoryDao.save(t);
	}

	public void delete(Serializable id) {

		
	}

	public void update(TraceHistory t) {

		
	}

	public List<TraceHistory> findByPage(int index, int count) {

		return null;
	}

	public Long findTotalCount() {

		return null;
	}

	public PageBean<TraceHistory> findPageByCondition(Condition condition,
			int currentPage, int pageSize) {
		return null;
	}


	public List<TraceHistory> findByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
