package com.example.graduation.daoImp;


import com.example.graduation.dao.ProjectDAO;
import com.example.graduation.model.Project;
import com.example.graduation.vo.Page;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class ProjectDAOImp extends IDAOImpl<Project> implements ProjectDAO {
    @Override
    public List<Project> getProjectsByTeId(Integer teId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from Project where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,teId);
        return sqlQuery.list();
    }

    @Override
    public List<Project> getProjectsByTeIdAndPage(Integer teId, Page page) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from Project where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,teId);
        Integer start=(page.getCurrentPage()-1)*page.getLineSize();
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(page.getLineCount());
        return sqlQuery.list();
    }

    @Override
    public List<Project> getProjectsByIds(Serializable... ids) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from Project where paId in (:ids)");
        Query query=session.createQuery(sql.toString());
        query.setParameterList("ids", ids);
        return query.list();
    }


    @Override
    public Integer getProjectsCountByStateAndYear(String state,String year) {
        Session session=sessionFactory.getCurrentSession();
        StringBuilder sb=new StringBuilder("select count(1) as count from t_paper where pastate=? and substr(to_char(pastarttime,'yyyy-mm-dd'),0,4)=?");
        SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
        sqlQuery.setParameter(0,state);
        sqlQuery.setParameter(1,year);
        sqlQuery.addScalar("count", IntegerType.INSTANCE);
        return (Integer)sqlQuery.uniqueResult();
    }

}
