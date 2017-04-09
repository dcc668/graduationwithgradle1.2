package com.example.graduation.dao;

import java.io.Serializable;
import java.util.Collection;

public interface IDAO<T> {
	/**
	 * 
	 *
	 * @param t
	 */
		public void add(T t);
		
		/**
		 * 
		 * 
		 * @param id
		 */
		public void deleteById(Serializable id);
		
		/**
		 * 
		 * 
		 * @param collection
		 */
		public void deleteByCollection(Collection<T> collection);
		
		/**
		 * 
		 * ͨ
		 * @param id
		 * @return
		 */
		public T findById(Serializable id);
		
		/**
		 * 
		 * 查找全部并分页
		 * @param firstResult	
		 * @param maxResults 
		 * @return
		 */
		public Collection<T> findAllAndPage(int firstResult, int maxResults);
		
		/**
		 * 
		 * 查找全部
		 * @return
		 */
		public Collection<T> findAll();
		
		/**
		 * 更新
		 * @param t
		 */
		public void update(T t);


		public Integer getCount(T t);

}
