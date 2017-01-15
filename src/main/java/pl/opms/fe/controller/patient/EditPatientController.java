package pl.opms.fe.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.PhoneNumberEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.validator.PatientValidator;

import javax.annotation.PostConstruct;

/**
 * Created by Adam on 2017-01-03.
 */
@Controller
@SessionAttributes("patientEntity")
//@RequestMapping("/patient/edit")
public class EditPatientController {

    @Autowired
    transient private PatientService patientService;

    @Autowired
    private PatientValidator patientValidator;

    private static Long id;

//    @PostConstruct
//    public void init() {
//    }

//    @RequestMapping(value = "/patient/edit/editPatient")
//    public String info(Model model) {
//        return "/patient/edit/editPatient";
//    }

    @RequestMapping(value = "/patient/edit/editPatient")
    public String requestInfo(@ModelAttribute("patientEntity") PatientEntity patientEntity) {
        return "/patient/edit/editPatient";
    }

    @RequestMapping(value = "/patient/edit/editPatient", params = {"id"})
    public String requestInfo(@RequestParam(required = true) Long id,
                              ModelMap modelMap) {
        this.id=id;
        PatientEntity patientEntity = patientService.findOne(id);
        patientEntity.getPersonalDataEntity().setIsMailAddress(false);
        modelMap.addAttribute("patientEntity",patientEntity);
        return "/patient/edit/editPatient";
    }

    @RequestMapping(value = "/patient/edit/edit", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute("patientEntity") PatientEntity patientEntity, BindingResult result, ModelMap modelMap,
                                    RedirectAttributes redirectAttributes, SessionStatus status) {
        patientValidator.validate(patientEntity,result);
//        if (result.hasErrors()) {
//            System.out.println(result.getFieldErrors());
////            ModelAndView modelAndView = new ModelAndView("redirect:/patient/edit/editPatient");
////            return modelAndView;
//            return "redirect:/patient/edit/editPatient";
//        }
        try {
            System.out.println(patientEntity);
            patientService.update(patientEntity);
        } catch (Exception e) {
            modelMap.addAttribute("error", true);
            return "redirect:/patient/edit/editPatient";
        }
        status.setComplete();
        redirectAttributes.addAttribute("success", true);
        return "redirect:/patient/info/infoPatient"+"?id="+patientEntity.getId();
    }

    @RequestMapping(value = "/patient/edit/edit", params = {"addPhone"}, method = RequestMethod.POST)
    public String addRow(@ModelAttribute("patientEntity") PatientEntity patientEntity) {
        patientEntity.getPersonalDataEntity().getPhoneNumbers().add(new PhoneNumberEntity());
        return "/patient/edit/editPatient";
    }


    @RequestMapping(value = "/patient/edit/edit", params = {"removePhone"})
    public String removeRow(@RequestParam(value = "removePhone", required = false, defaultValue = "0") int index,
                            @ModelAttribute("patientEntity") PatientEntity patientEntity) {
        if (index >= 0 && index < patientEntity.getPersonalDataEntity().getPhoneNumbers().size()) {
            patientEntity.getPersonalDataEntity().getPhoneNumbers().remove(index);
        }
        return "/patient/edit/editPatient";
    }

    @RequestMapping(value = "/patient/edit/edit", params = {"mailAddress"})
    public String mailAddress(@ModelAttribute("patientEntity") PatientEntity patientEntity) {
        return "/patient/edit/editPatient";
    }

}