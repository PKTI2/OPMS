package pl.opms.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.*;
import pl.opms.be.service.AddPatientService;
import pl.opms.be.utils.role.PrivilegesOutdatedException;
import pl.opms.be.utils.role.RoleUtil;
import pl.opms.consts.BloodType;
import pl.opms.consts.Gender;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Val on 2016-12-13.
 */
@Controller
public class AddPatientController {

    @Autowired
    private AddPatientService addPatientService;

    private PatientEntity patientEntity;
    private PatientDataEntity patientDataEntity;
    private PersonalDataEntity personalDataEntity;
    private AddressEntity addressEntity;
    private DepartmentEntity departmentEntity;
    private RoomEntity roomEntity;


    @PostConstruct
    public void init() {
//        patientEntity

    }

    @ModelAttribute("patient")
    public PatientEntity populatePatient() {
        return new PatientEntity(new PatientDataEntity(0, BloodType.A,true,(float)0.0,Gender.MALE,new DepartmentEntity(new ArrayList<RoomEntity>()," "),new RoomEntity()),new PersonalDataEntity(" "," ", new AddressEntity(" "," "," "," "),new AddressEntity(" "," "," "," "),new ArrayList<PhoneNumberEntity>()," ",new Date()));
//        return new PatientEntity();
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/patient/add/addpatient");
        return modelAndView;
    }

    @RequestMapping(value = "/patient/add/addPatient", method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute("patient") PatientEntity patientEntity, BindingResult result, ModelMap modelMap,
                                   RedirectAttributes redirectAttributes) {
        System.out.println("test");
        this.patientEntity = patientEntity;
        this.patientEntity.getPatientData().setBloodAntigen(true);
        this.patientEntity.getPatientData().setGender(Gender.MALE);
        this.patientEntity.getPersonalDataEntity().getPhoneNumberList().add(new PhoneNumberEntity("kom","123-456-789"));

        /*patientEntity = new PatientEntity();
        patientDataEntity = new PatientDataEntity();
        personalDataEntity = new PersonalDataEntity();
        addressEntity = new AddressEntity();*/


        ModelAndView modelAndView = new ModelAndView("redirect:/patient/add");
        return modelAndView;
    }

}
