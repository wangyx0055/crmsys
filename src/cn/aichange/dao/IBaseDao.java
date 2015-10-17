package cn.aichange.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
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
	
	/**
	 * 根据条件查询（不分页）
	 * @param hql		查询hql语句
	 * @param values	条件参数
	 * @return			查询对象集结果
	 */
	public List<T> findByCondition(final String hql, final Object...values);
	
	
	/**
	 * 根据条件进行分页查询！
	 * @param hql      条件查询的hql语句， 例如： from Customer where name=? and address=?       
	 * @param values   占位符问号对应的值
	 * @param index    查询起始行(由当前页计算出)
	 * @param count    查询返回的行(每页显示行)
	 * @return
	 */
	public List<T> findPageByCondition(String hql, List<Object> values,int index, int count);
   
	/**
	 * 根据条件统计！
	 * @param hql     统计查询的hql语句： 如select count(*) from Customer where name=? and address=? 
	 * @param values  占位符问号对应的值
	 * @return
	 */
	public Long  findTotalCountByCondition(String hql, List<Object> values);
}
