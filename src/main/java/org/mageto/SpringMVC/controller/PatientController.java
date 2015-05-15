package org.mageto.SpringMVC.controller;

import org.mageto.SpringMVC.model.Drug;
import org.mageto.SpringMVC.model.Patient;
import org.mageto.SpringMVC.service.DrugService;
import org.mageto.SpringMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by denis on 5/11/15.
 */
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DrugService drugService;

    //public void setPatientService(PatientService patientService) {
//        this.patientService = patientService;
//    }
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView();
        model.addObject("getPatient", patientService.getPatient());
        model.setViewName("Patient");
        return model;
    }

    @RequestMapping(value = "patients", method = RequestMethod.GET)
    public ModelAndView getPatientPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("patients", new Patient());
        model.addObject("listPatients", this.patientService.getPatient());
        model.setViewName("Patient");
        return model;
    }


//    @RequestMapping(value = "patients", method = RequestMethod.GET)
//    public String getPatientPage(Model model){
//        model.addAttribute("patients", new Patient());
//        model.addAttribute("list patients", this.patientService.getPatient());
//        return "patient";
//    }

//    @RequestMapping("/create")
//    public ModelAndView create(@RequestParam(value = "fname", required = false) String fname,
//                               @RequestParam(value = "lname", required = false) String lname,
//                               @RequestParam(value = "dob", required = false) String dob
//    ){
//        ModelAndView model = new ModelAndView();
//
//
//        Patient patient = new Patient();
//        patient.setFname(fname);
//        patient.setLname(lname);
//        patient.setDob(dob);
//        patientService.addPatient(patient);
//        model.addObject("getPatient", patientService.getPatient());
//        model.addObject("msg", "Patient Added Successfully");
//        model.setViewName("Patient");
//        return model;
//    }
//    @RequestMapping(value = "patients/load", method = RequestMethod.POST)
//    public String createOrEditUser(@ModelAttribute("patient")Patient patient){
//        if (patient.getPid()==0){
//            this.patientService.addPatient(patient);
//        }else{
//            this.patientService.updatePatient(patient);
//        }
//        return "redirect:/patients";
//    }
    @RequestMapping("/create")
    public ModelAndView create(@RequestParam(value = "fname", required = false) String fname,
                               @RequestParam(value = "lname", required = false) String lname,
                               @RequestParam(value = "dob", required = false) String dob
    ){
        ModelAndView model = new ModelAndView();


        Patient patient = new Patient();
        patient.setFname(fname);
        patient.setLname(lname);
        patient.setDob(dob);
        patientService.addPatient(patient);
        model.addObject("getPatient", patientService.getPatient());
        model.addObject("msg","Patient Added Successfully");
        model.setViewName("Patient");
        return model;
    }

    @RequestMapping(value= "/allocate", method = RequestMethod.GET)
    public ModelAndView displayPatient(@RequestParam(value = "id", required = false) int id){
        ModelAndView model = new ModelAndView("allocate");
        model.addObject("patient", patientService.getPatient(id));
        return model;
    }
//    @RequestMapping("/save")
//    public ModelAndView save(@RequestParam(value = "patient_id", required = false) int pid,
//                             @RequestParam(value = "dname", required = false) String dname
//    ){
//        ModelAndView model = new ModelAndView();
//        Drug drug = new Drug();
//        drug.setDname(dname);
//        drug.setPid(pid);
//        drugService.addDrug(drug);
//        model.addObject("listDrug", drugService.listDrug());
//        model.addObject("msg","Patient Allocated drug Successfully");
//        model.setViewName("allocate");
//        return model;
//    }

    @RequestMapping(value = "patients/edit/{id}")
    public  String editParient(@PathVariable("id") int id, Model model){
        model.addAttribute("patients", new Patient());
        model.addAttribute("patients", this.patientService.getPatient(id));

        return "patient";
    }

    @RequestMapping(value = "patients/delete/{id}")
    public String deletePatient(@PathVariable("id") int id, Model model){
        this.patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam(value = "patient_id", required = false) int pid,
                             @RequestParam(value = "dname", required = false) String dname){
        ModelAndView model = new ModelAndView();
        Drug drug = new Drug();
        drug.setDrug_name(dname);
        drug.setDid(pid);
        drugService.addDrug(drug);
        model.addObject("listDrug", drugService.getDrug());
        model.addObject("msg", "Patient Allocated drug Successfully");
        model.setViewName("allocate");
        return model;
    }
    @RequestMapping("/drug")
    public ModelAndView viewdrugs(){
        ModelAndView model = new ModelAndView();
        List<Drug> drugList = drugService.getDrug();
        model.addObject("drugPatient", drugList);
        model.setViewName("drug");
        return model;
    }

}
