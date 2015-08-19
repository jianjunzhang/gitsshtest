package cn.buaa.dao;

import java.util.List;

import cn.buaa.model.Pager;

public interface IBaseDao<T> {

	public abstract void add(T t);

	public abstract void update(T t);

	public abstract void delete(int id);

	public abstract T load(int id);

	public abstract List<T> list(String hql, Object[] args);
	
	public abstract List<T> list(String hql);
	
	public abstract List<T> list(String hql, Object args);
	
	public Pager<T> find(String hql,Object[] args);
	
	public Pager<T> find(String hql);
	
	public Pager<T> find(String hql,Object args);

}