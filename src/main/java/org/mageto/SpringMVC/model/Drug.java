package org.mageto.SpringMVC.model;

import javax.persistence.*;

/**
 * Created by denis on 5/11/15.
 */
@Entity
@Table(name = "drug", schema = "patient")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private int did;

    @Column(name="pid")
    private int pid;

    @Column(name = "drug_name")
    private String drug_name;

    @ManyToOne
    @JoinColumn(name = "pid", updatable = false, insertable = false)
    private Patient patient;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "did=" + did +
                ", drug_name='" + drug_name + '\'' +
                ", patient=" + patient +
                '}';
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
