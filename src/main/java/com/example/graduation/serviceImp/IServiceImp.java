package com.example.graduation.serviceImp;

import com.example.graduation.dao.IDAO;
import com.example.graduation.service.IService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service("iServiceImp")
public class IServiceImp<T>   implements IService<T>{

	@Resource(name="iDAOImp")
	IDAO<T> iDAO;


	public void add(T t) {
		iDAO.add(t);
	}


	@Override
	public void deleteById(Serializable id) {
		iDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection <T>collection) {
		iDAO.deleteByCollection(collection);
	}

	@Override
	public T findById(Serializable id) {
		T t=(T)iDAO.findById(id);
		return t;
	}

	@Override
	public void update(T t) {
		iDAO.update(t);
	}

	@Override
	public Integer getCount(T t) {
		return iDAO.getCount(t);
	}

	@Override
	public Collection<T> findAllAndPage(int firstResult, int maxResults) {
		Collection<T> coll=iDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}


	@Override
	public Collection<T> findAll() {
		return null;
	}
	
}
