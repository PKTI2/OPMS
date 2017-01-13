package pl.opms.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.PhoneNumberEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.validator.PatientValidator;

import javax.annotation.PostConstruct;

/**
 * Created by Val on 2016-12-13.
 */
@Controller
public class AddPatientController {

    @Autowired
    private PatientService patientService;

//    private PatientEntity patientEntity;
    @Autowired
    private PatientValidator patientValidator;


    @PostConstruct
    public void init() {
//        patientEntity

    }

    @ModelAttribute("patient")
    public PatientEntity populatePatient() {
        return new PatientEntity();//(new UserEntity(patientEntity.getPersonalDataEntity().getPeselNumber(),"123",true, ,patientEntity.getPersonalDataEntity()));
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/patient/add/addpatient");
        return modelAndView;
    }

    @RequestMapping(value = "/patient/add/addPatient", method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute("patient") PatientEntity patientEntity, BindingResult result) {
        System.out.println("test");
        System.out.println(patientEntity);
        patientValidator.validate(patientEntity,result);
        patientService.save(patientEntity);

        ModelAndView modelAndView = new ModelAndView("redirect:/patient/add");
        return modelAndView;
    }

    @RequestMapping(value = "/patient/add/addPatient", params = {"addPhone"}, method = RequestMethod.POST)
    public String addRow(@ModelAttribute("patient") PatientEntity patientEntity) {
        patientEntity.getPersonalDataEntity().getPhoneNumbers().add(new PhoneNumberEntity());
        return "/patient/add/addPatient";
    }


    @RequestMapping(value = "/patient/add/addPatient", params = {"removePhone"})
    public String removeRow(@RequestParam(value = "removePhone", required = false, defaultValue = "0") int index,
                            @ModelAttribute("patient") PatientEntity patientEntity) {
        if (index >= 0 && index < patientEntity.getPersonalDataEntity().getPhoneNumbers().size()) {
            patientEntity.getPersonalDataEntity().getPhoneNumbers().remove(index);
        }
        return "/patient/add/addPatient";
    }


}
