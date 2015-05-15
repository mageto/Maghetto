package org.mageto.SpringMVC.service;

import org.mageto.SpringMVC.dao.PatientDao;
import org.mageto.SpringMVC.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denis on 5/11/15.
 */
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Override
    public void addPatient(Patient patient) {
        this.getPatientDao().addPatient(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        this.getPatientDao().updatePatient(patient);
    }

    @Override
    public List<Patient> getPatient() {
        return this.getPatientDao().getPatient();
    }

    @Override
    public Patient getPatient(int id) {
        return this.getPatientDao().getPatient(id);
    }

    @Override
    public void deletePatient(int id) {
        this.getPatientDao().deletePatient(id);
    }

    @Override
    public List<Patient> findAllWithDrugs() {
        return patientDao.findAllWithDrugs();
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }
}
