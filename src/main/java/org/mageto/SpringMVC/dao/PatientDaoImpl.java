package org.mageto.SpringMVC.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.mageto.SpringMVC.model.Patient;
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
public class PatientDaoImpl implements PatientDao {

    @Autowired
    SessionFactory sessionFactory;
    private static final Logger logger= LoggerFactory.getLogger(PatientDaoImpl.class);

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        ///Serializable id = session.getIdentifier(patient);
        session.close();
        logger.info("New patient with name"+patient.getFname()+" "+patient.getLname());
    }

    @Override
    public void updatePatient(Patient patient) {
        Session session = this.getSessionFactory().getCurrentSession();
        session.update(patient);
        logger.info(patient.getFname() + " " + patient.getLname()+" "+"was updated");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getPatient() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Patient> patientList = session.createQuery("from Patient").list();
        session.close();
        logger.info("Number of patients = " + patientList.size());
        return patientList;
    }

    @Override
    public Patient getPatient(int id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Patient.class);
        criteria.add(Restrictions.eq("id", id));
        Patient patient = (Patient) criteria.uniqueResult();
        session.close();
        return patient;
    }

    @Override
    public void deletePatient(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Patient patient = (Patient) session.load(Patient.class, new Integer(id));

        if (null != patient){
            logger.info(patient.getFname()+" "+patient.getLname()+" "+"was deleted.");
            session.delete(patient);
        }
    }

    @Override
    public List<Patient> findAllWithDrugs() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Patient> patientWithDrugList = session.createQuery("from Patient").list();
        session.close();
        return patientWithDrugList;
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        sessionFactory = sessionFactory;
    }
}
