package com.example.graduation.daoImp;


import com.example.graduation.dao.TeacherProjectDAO;
import com.example.graduation.model.TeacherProject;
import com.example.graduation.vo.Page;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TeacherProjectDAOImp extends IDAOImpl<TeacherProject> implements TeacherProjectDAO {
    @Override
    public List<TeacherProject> findByTeacherId(Serializable id) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from TeacherProject where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,id);
        return sqlQuery.list();
    }

    @Override
    public List<TeacherProject> findByTeacherIdAndPage(Serializable id,Page page) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from TeacherProject where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,id);
        Integer start=(page.getCurrentPage()-1)*page.getLineSize();
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(page.getLineCount());
        return sqlQuery.list();
    }

    @Override
    public List<TeacherProject> findByProjectId(Serializable id) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from TeacherProject where prId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,id);
        return sqlQuery.list();
    }

    @Override
    public TeacherProject findByPrIdAndTeId(Serializable prId, Serializable teId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("select * from t_teacher_project where prId= ?and teId=?");
        SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
            sqlQuery.setParameter(0,prId);
            sqlQuery.setParameter(1,teId);
            sqlQuery.addEntity(TeacherProject.class);
        return (TeacherProject)sqlQuery.uniqueResult();
    }

}
