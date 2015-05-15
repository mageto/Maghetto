package org.mageto.SpringMVC.service;

import org.mageto.SpringMVC.model.Drug;

import java.util.List;

/**
 * Created by denis on 5/11/15.
 */
public interface DrugService {
    public int addDrug(Drug drug);

    public void updateDrug(Drug drug);

    public List<Drug> getDrug();

    public Drug getDrug(int id);

    public void deleteDrug(int id);
}
