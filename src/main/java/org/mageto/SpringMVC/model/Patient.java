//package org.mageto.SpringMVC.model;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.util.List;
//
///**
// * Created by denis on 5/11/15.
// */
//@Entity
//@Table(name = "patient", schema="patient")
//
//public class Patient {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "pid")
//    private int pid;
//
//    @Column(name = "fname")
//    private String fname;
//
//    @Column(name = "lname")
//    private String lname;
//
//    @Column(name = "dob")
//    private String dob;
//
//    @Column(name = "time")
//    private Timestamp time;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Drug> drugs;
//    public int getPid() {
//        return pid;
//    }
//
//    public void setPid(int pid) {
//        this.pid = pid;
//    }
//
//    public String getFname() {
//        return fname;
//    }
//
//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//
//    public String getLname() {
//        return lname;
//    }
//
//    public void setLname(String lname) {
//        this.lname = lname;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public Timestamp getTime() {
//        return time;
//    }
//
//    public void setTime(Timestamp time) {
//        this.time = time;
//    }
//
//    public List<Drug> getDrugs() {
//        return drugs;
//    }
//
//    public void setDrugs(List<Drug> drugs) {
//        this.drugs = drugs;
//    }
//
//    @Override
//    public String toString() {
//        return "Patient{" +
//                "pid=" + pid +
//                ", fname='" + fname + '\'' +
//                ", lname='" + lname + '\'' +
//                ", dob=" + dob +
//                ", time=" + time +
//                ", drugs=" + drugs +
//                '}';
//    }
//
//
//}
package org.mageto.SpringMVC.model;

        import javax.persistence.*;
        import java.util.List;
        import java.util.Set;

/**
 * Created by denis on 5/11/15.
 */
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue
    private int pid;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    @Column(name="dob")
    private String dob;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Drug> drugs;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob(){return dob;}
    public void setDob(String dob){this.dob = dob; }

   /* public String getDatecreated(String datecreated){ return datecreated;}
    public void setDatecreated(String datecreated){this.datecreated = datecreated;}*/

    public List<Drug> getDrug() {
        return drugs;
    }
    public void setDrug(List<Drug> drugs) {
        this.drugs = drugs;
    }

}
