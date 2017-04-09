package com.example.graduation.daoImp;


import com.example.graduation.dao.TitleDAO;
import com.example.graduation.model.Title;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository
public class TitleDAOImp extends IDAOImpl<Title> implements TitleDAO{

    @Override
    public Title getTitleById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
            SQLQuery sqlQuery = session.createSQLQuery("select  * from t_Title where titleId=" + id);
                sqlQuery.addEntity(Title.class);
        return (Title)sqlQuery.uniqueResult();
    }

    @Override
    public SubTitle getSubTitleId(Integer id) {
        Session session = sessionFactory.getCurrentSession();
            SQLQuery sqlQuery = session.createSQLQuery("select titleId,titleName from t_Title where titleId=" + id);
                sqlQuery.addScalar("titleId", IntegerType.INSTANCE);
                sqlQuery.addScalar("titleName", StringType.INSTANCE);
            sqlQuery.setResultTransformer(Transformers.aliasToBean(SubTitle.class));
        return (SubTitle)sqlQuery.uniqueResult();
    }

}
