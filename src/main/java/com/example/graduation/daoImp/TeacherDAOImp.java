package com.example.graduation.daoImp;


import com.example.graduation.dao.TeacherDAO;
import com.example.graduation.model.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImp extends IDAOImpl<Teacher> implements TeacherDAO {

	public List<Teacher> findByName(String name){
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Teacher where teName=?");
			query.setString(0, name);
		return (List<Teacher>)query.list();
	}

}
