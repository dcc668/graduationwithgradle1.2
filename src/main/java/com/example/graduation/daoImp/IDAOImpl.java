package com.example.graduation.daoImp;

import com.example.graduation.dao.IDAO;
import com.example.graduation.util.GenericSuperClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository("iDAOImp")
public class IDAOImpl<T>   implements IDAO<T>{
	
		//类型转换
	private Class entity = GenericSuperClass.getSuperClassGenricType(this.getClass());
	@Autowired
	SessionFactory sessionFactory;
	public Serializable add(T t) {
		Session session=sessionFactory.getCurrentSession();
			return session.save(t);
	}

	@Override
	public void deleteById(Serializable id)  {
		Session session=sessionFactory.getCurrentSession();
			T t=null;
			if(id!=null){
				t=(T)session.get(entity, id);
			}else{
				System.out.println("id is null!");}
			if(t!=null){
				session.delete(t);
			}
	}
	
	

	@Override
	public void deleteByCollection(Collection <T>collection) {
		Session session=sessionFactory.getCurrentSession();
			for(T t:collection){
				session.delete(t);
			}
	}
	

	@Override
	public T findById(Serializable id) {
		System.out.println(" IDAO==findBYId==sessionFac"+sessionFactory);
		Session session=sessionFactory.getCurrentSession();
		T t=null;
			if(id!=null){
				 t=(T)session.get(entity, id);
			}else{System.out.println("id is null");}
		return t;
	}

	@Override
	public void update(T t) {
		Session session=sessionFactory.getCurrentSession();
			session.update(t);
	}

	@Override
	public Integer getCount(T t) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from "+entity.getSimpleName()+"");
		if(!CollectionUtils.isEmpty(query.list())) {
			return (Integer) query.list().size();
		}else{
			return 0;
		}
	}

	@Override
	public Collection<T> findAllAndPage(int firstResult, int maxResults) {
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from "+entity.getSimpleName()+"");
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
		return (List<T>)query.list();
	}

	
	@Override
	public Collection<T>findAll () {
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from "+entity.getSimpleName()+"");
		return (List<T>)query.list();
	}



	
}
