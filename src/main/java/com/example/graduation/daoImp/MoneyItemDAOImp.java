package com.example.graduation.daoImp;


import com.example.graduation.dao.MoneyItemDAO;
import com.example.graduation.model.MoneyItem;
import com.example.graduation.vo.Page;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class MoneyItemDAOImp extends IDAOImpl<MoneyItem> implements MoneyItemDAO {

    @Override
    public List<MoneyItem> getMoneyItemsByPrId(Integer prId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from MoneyItem where prId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,prId);
        return sqlQuery.list();
    }

    @Override
    public List<MoneyItem> getMoneyItemsByPrIdAndPage(Integer prId, Page page) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer sql=new StringBuffer("from MoneyItem where teId= ?");
        Query sqlQuery = session.createQuery(sql.toString());
        sqlQuery.setParameter(0,prId);
        Integer start=(page.getCurrentPage()-1)*page.getLineSize();
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(page.getLineCount());
        return sqlQuery.list();
    }

    @Override
    public List<MoneyItem> getMoneyItemsByIds(Serializable... ids) {
            Session session=sessionFactory.getCurrentSession();
            StringBuffer sql=new StringBuffer("from MoneyItem where paId in (:ids)");
            Query query=session.createQuery(sql.toString());
            query.setParameterList("ids", ids);
            return query.list();
    }


    @Override
    public Integer getMoneyItemsCountByPrId(Integer prId) {
        Session session=sessionFactory.getCurrentSession();
        StringBuilder sb=new StringBuilder("select count(1) as count from t_MoneyItem where prId=?");
        SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
            sqlQuery.setParameter(0,prId);
            sqlQuery.addScalar("count", IntegerType.INSTANCE);
        return (Integer)sqlQuery.uniqueResult();
    }

}

