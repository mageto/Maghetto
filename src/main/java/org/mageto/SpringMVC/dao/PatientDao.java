package org.mageto.SpringMVC.dao;

import org.mageto.SpringMVC.model.Patient;

import java.util.List;

/**
 * Created by denis on 5/11/15.
 */
public interface PatientDao {
    public void addPatient(Patient patient);

    public void updatePatient(Patient patient);

    public List<Patient>getPatient();

    public Patient getPatient(int id);

    public void deletePatient(int id);

    public List<Patient> findAllWithDrugs();
}
