package com.example.graduation.daoImp;


import com.example.graduation.dao.PreMoneyItemDAO;
import com.example.graduation.model.PreMoneyItem;
import com.example.graduation.vo.Page;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class PreMoneyItemDAOImp extends IDAOImpl<PreMoneyItem> implements PreMoneyItemDAO {

    @Override
    public List<PreMoneyItem> getPreMoneyItemsByPrId(Integer prId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from PreMoneyItem where prId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,prId);
        return sqlQuery.list();
    }

    @Override
    public List<PreMoneyItem> getPreMoneyItemsByPrIdAndPage(Integer prId, Page page) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from PreMoneyItem where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,prId);
        Integer start=(page.getCurrentPage()-1)*page.getLineSize();
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(page.getLineCount());
        return sqlQuery.list();
    }

    @Override
    public List<PreMoneyItem> getPreMoneyItemsByIds(Serializable... ids) {
            Session session=sessionFactory.getCurrentSession();
            StringBuffer sql=new StringBuffer("from PreMoneyItem where paId in (:ids)");
            Query query=session.createQuery(sql.toString());
            query.setParameterList("ids", ids);
            return query.list();
    }


    @Override
    public Integer getPreMoneyItemsCountByPrId(Integer prId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuilder sb=new StringBuilder("select count(1) as count from t_PreMoneyItem where prId=?");
        SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
            sqlQuery.setParameter(0,prId);
            sqlQuery.addScalar("count", IntegerType.INSTANCE);
        return (Integer)sqlQuery.uniqueResult();
    }

    @Override
    public Double calculateSumMoneyByPrId(Integer prId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuilder sb=new StringBuilder("select sum(summoney) as count from t_PreMoneyItem where prId=?");
        SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
        sqlQuery.setParameter(0,prId);
        sqlQuery.addScalar("count", DoubleType.INSTANCE);
        return (Double)sqlQuery.uniqueResult();
    }

}

