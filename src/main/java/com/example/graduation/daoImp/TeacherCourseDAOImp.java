package com.example.graduation.daoImp;


import com.example.graduation.dao.TeacherCourseDAO;
import com.example.graduation.model.TeacherCourse;
import com.example.graduation.vo.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TeacherCourseDAOImp extends IDAOImpl<TeacherCourse> implements TeacherCourseDAO {
    @Override
    public List<TeacherCourse> findByTeacherId(Serializable id) {
            Session session=sessionFactory.getCurrentSession();
                StringBuffer sql=new StringBuffer("from TeacherCourse where teId= ?");
                Query sqlQuery = session.createQuery(sql.toString());
                    sqlQuery.setParameter(0,id);
            return sqlQuery.list();
    }

    @Override
    public List<TeacherCourse> findByTeacherIdAndPage(Serializable id,Page page) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from TeacherCourse where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
            sqlQuery.setParameter(0,id);
            Integer start=(page.getCurrentPage()-1)*page.getLineSize();
            sqlQuery.setFirstResult(start);
            sqlQuery.setMaxResults(page.getLineCount());
        return sqlQuery.list();
    }

    @Override
    public List<TeacherCourse> findByCourseId(Serializable id) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from TeacherCourse where coNo= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,id);
        return sqlQuery.list();
    }
}
