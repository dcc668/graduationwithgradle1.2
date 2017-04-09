package com.example.graduation.daoImp;


import com.example.graduation.dao.TitleReviewInforDAO;
import com.example.graduation.model.TitleReviewInfor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitleReviewInforDAOImp extends IDAOImpl<TitleReviewInfor> implements TitleReviewInforDAO {
	
	public List<TitleReviewInfor> findNotReview(){
		
		
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from TitleReviewInfor where reviewState ='审核中'");
		return (List<TitleReviewInfor>)query.list();
	}

	@Override
	public List<TitleReviewInfor> findDoneReview() {
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from TitleReviewInfor where reviewState ='通过'");
		return (List<TitleReviewInfor>)query.list();
	}
	





}
