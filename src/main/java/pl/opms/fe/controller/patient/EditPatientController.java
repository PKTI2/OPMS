package pl.opms.fe.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.service.PatientService;

import javax.annotation.PostConstruct;

/**
 * Created by Adam on 2017-01-03.
 */
@Controller
//@RequestMapping("/patient/edit")
public class EditPatientController {

    @Autowired
    transient private PatientService patientService;

//    @PostConstruct
//    public void init() {
//    }

    @RequestMapping(value = "/patient/edit/editPatient")
    public String info(Model model) {
        return "/patient/edit/editPatient";
    }

    @RequestMapping(value = "/patient/edit/edit", method = RequestMethod.POST)
    public ModelAndView editPatient(@ModelAttribute("patientEntity") PatientEntity patientEntity, BindingResult result) {
        patientService.save(patientEntity);
        ModelAndView modelAndView = new ModelAndView("redirect:/patient/edit/editPatient");
        return modelAndView;
    }

}
