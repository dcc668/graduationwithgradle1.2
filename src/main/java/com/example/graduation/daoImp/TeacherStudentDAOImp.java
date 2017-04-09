package com.example.graduation.daoImp;


import com.example.graduation.dao.TeacherStudentDAO;
import com.example.graduation.model.TeacherStudent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherStudentDAOImp extends IDAOImpl<TeacherStudent> implements TeacherStudentDAO{

	@Override
	public List<TeacherStudent> queryScore(int sId) {
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from TeacherStudent  where sId=?");
			query.setParameter(0,sId);
		return query.list();
	}
}
