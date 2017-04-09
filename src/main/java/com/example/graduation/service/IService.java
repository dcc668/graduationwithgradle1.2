package com.example.graduation.service;

import java.io.Serializable;
import java.util.Collection;

public interface IService<T> {
		public void add(T t);
		public void deleteById(Serializable id);
		public void deleteByCollection(Collection<T> collection);
		public T findById(Serializable id);
		public Collection<T> findAllAndPage(int firstResult, int maxResults);
		public Collection<T> findAll();
		public void update(T t);
		public Integer getCount(T t);
}
