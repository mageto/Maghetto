package org.mageto.SpringMVC.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.mageto.SpringMVC.model.Drug;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by denis on 5/11/15.
 */
@Repository
public class DrugDaoImpl implements DrugDao{

    @Autowired
    org.hibernate.SessionFactory sessionFactory;
    private static final Logger logger= LoggerFactory.getLogger(DrugDaoImpl.class);

    @Override
    @Transactional
    public int addDrug(Drug drug) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(drug);
        tx.commit();
        Serializable id = session.getIdentifier(drug);
        session.close();
        return (Integer) id;
    }

    @Override
    public void updateDrug(Drug drug) {
        Session session = this.getSessionFactory().getCurrentSession();
        session.update(drug);
        logger.info(drug.getDrug_name()+" "+"was updated");
    }

    @Override
    public List<Drug> getDrug() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Drug> drugList = session.createQuery("from Drug").list();
        session.close();
        return drugList;
    }

    @Override
    public Drug getDrug(int id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Drug.class);
        criteria.add(Restrictions.eq("id", id));
        Drug drug = (Drug) criteria.uniqueResult();
        session.close();
        return drug;
    }

    @Override
    public void deleteDrug(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Drug drug = (Drug) session.load(Drug.class, new Integer(id));

        if (null != drug){
            logger.info(drug.getDrug_name()+" "+"was deleted.");
            session.delete(drug);
        }
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        Session session = this.getSessionFactory().getCurrentSession();
        return sessionFactory;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        sessionFactory = sessionFactory;
    }
}
