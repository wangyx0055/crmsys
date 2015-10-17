package cn.aichange.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.aichange.bean.TransferHistory;
import cn.aichange.dao.ITransferHistoryDao;
import cn.aichange.service.ITransferHistoryService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

public class TransferHistoryService implements ITransferHistoryService {
	//注入dao
	private ITransferHistoryDao transferHistoryDao;
	public void setTransferHistoryDao(ITransferHistoryDao transferHistoryDao) {
		this.transferHistoryDao = transferHistoryDao;
	}
	
	
	public List<TransferHistory> findAll() {
		return transferHistoryDao.findAll();
	}

	public TransferHistory findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(TransferHistory t) {
		transferHistoryDao.save(t);
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	public void update(TransferHistory t) {
		// TODO Auto-generated method stub

	}

	public List<TransferHistory> findByPage(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long findTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageBean<TransferHistory> findPageByCondition(Condition condition,
			int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<TransferHistory> findByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
