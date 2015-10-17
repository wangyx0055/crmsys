package cn.aichange.service;

import java.io.Serializable;
import java.util.List;

import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

public interface IBaseService<T> {
	//查询所有
	public List<T> findAll();
	
	//根据id查询
	public T findById(Serializable id);
	
	//保存
	public void save(T t);
	
	//删除
	public void delete(Serializable id);
	
	//更新
	public void update(T t);
	
	//分页查询
	@Deprecated
	public List<T> findByPage(int index, int count);
	
	//总记录数
	@Deprecated
	public Long findTotalCount();
	
	
	//根据条件查找记录
	public List<T> findByCondition(Condition condition);
	
	
	/**
	 * 根据条件分页查找
	 * @param con			查找条件
	 * @param currentPage	当前页
	 * @param pageSize		每页记录数
	 * @return	
	 */
	public PageBean<T> findPageByCondition(Condition condition, int currentPage, int pageSize);
	
	
}
