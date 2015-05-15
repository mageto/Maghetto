package org.mageto.SpringMVC.service;

import org.mageto.SpringMVC.dao.DrugDao;
import org.mageto.SpringMVC.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denis on 5/11/15.
 */
public class DrugServiceImpl implements DrugService {
    @Autowired
    DrugDao drugDao;
    @Override
    public int addDrug(Drug drug) {
        return this.getDrugDao().addDrug(drug);
    }

    @Override
    public void updateDrug(Drug drug) {
        this.getDrugDao().updateDrug(drug);
    }

    @Override
    public List<Drug> getDrug() {
        return this.getDrugDao().getDrug();
    }

    @Override
    public Drug getDrug(int id) {
        return this.getDrugDao().getDrug(id);
    }

    @Override
    public void deleteDrug(int id) {
        this.getDrugDao().deleteDrug(id);
    }

    public DrugDao getDrugDao() {
        return drugDao;
    }

    public void setDrugDao(DrugDao drugDao) {
        this.drugDao = drugDao;
    }
}
