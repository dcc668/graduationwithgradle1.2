package com.example.graduation.daoImp;


import com.example.graduation.dao.CourseDAO;
import com.example.graduation.model.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImp extends IDAOImpl<Course> implements CourseDAO {

    @Override
    public List<Course> findBySchool(String school) {
            Session session=sessionFactory.getCurrentSession();
                Query query=session.createQuery("from Course where school=?");
                query.setString(0, school);
            return (List<Course>)query.list();
    }
}
