package com.example.graduation.daoImp;


import com.example.graduation.dao.StudentDAO;
import com.example.graduation.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp extends IDAOImpl<Student> implements StudentDAO{

	public List<Student> findByName(String name){
		Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Student where sName=?");
			query.setString(0, name);
		return (List<Student>)query.list();
	}

}
