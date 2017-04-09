package com.example.graduation.daoImp;


import com.example.graduation.dao.ReviewerDAO;
import com.example.graduation.model.Reviewer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewerDAOImp extends IDAOImpl<Reviewer> implements ReviewerDAO {
	

	public List<Reviewer> findByName(String name){
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Reviewer where revName=?");
			query.setString(0, name);
		return (List<Reviewer>)query.list();
	}

	





}
