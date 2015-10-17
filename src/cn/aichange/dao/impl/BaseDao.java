package cn.aichange.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.aichange.dao.IBaseDao;

public abstract class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> clazz;
	private String className;
	//构造函数，获取T
	public BaseDao(){
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)type;
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class<T>) types[0];
		className = clazz.getSimpleName();
	}
	public List<T> findAll() {
		return getHibernateTemplate().find("from "+className);
	}

	public T findById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	public void delete(Serializable id) {
		T t = getHibernateTemplate().get(clazz, id);
		if(t != null){
			getHibernateTemplate().delete(t);
		}
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}
	
	@Deprecated
	public List<T> findByPage(int index, int count) {
		Query q = getSession().createQuery("from "+className);
		q.setFirstResult(index);
		q.setMaxResults(count);
		return q.list();
	}
	
	@Deprecated
	public Long findTotalCount() {
		Query q = getSession().createQuery("select count(id) from "+className);
		return (Long) q.uniqueResult();
	}
	
	public List<T> findByCondition(final String hql, final Object... values) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery(hql);
				if(values != null && values.length > 0){
					for(int i=0 ; i<values.length ; i++){
						q.setParameter(i, values[i]);
					}
				}
				return q.list();
			}
		});
	}
	
	
	public List<T> findPageByCondition(String hql, List<Object> values,
			int index, int count) {
		Query q = getSession().createQuery(hql);
		if(values != null && values.size() > 0){
			for(int i=0 ; i<values.size() ; i++){
				q.setParameter(i, values.get(i));
			}
		}
		q.setFirstResult(index);
		q.setMaxResults(count);
		return q.list();
	}
	
	public Long findTotalCountByCondition(String hql, List<Object> values) {
			Query q = getSession().createQuery(hql);
			if(values != null && values.size() > 0){
				for(int i=0 ; i<values.size() ; i++){
					q.setParameter(i, values.get(i));
				}
			}
		return (Long) q.uniqueResult();
	}

}
