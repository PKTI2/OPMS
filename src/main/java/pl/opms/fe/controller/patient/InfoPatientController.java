package pl.opms.fe.controller.patient;


import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.QPatientEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.validator.PatientValidator;

import javax.annotation.PostConstruct;

import static pl.opms.be.entity.QPatientEntity.patientEntity;


/**
 * Created by Adam on 2017-01-02.
 */
@Controller
public class InfoPatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientValidator patientValidator;

//    private Pageable pageable;
//    private Page<PatientEntity> page;
    private Predicate predicate;

    @PostConstruct
    public void init() {
        QPatientEntity qPatientEntity = patientEntity;
        predicate = patientEntity.personalDataEntity.firstName.contains("");

    }

//    @RequestMapping(value = "/patient/info/infoPatient")
//    public String info(Model model) {
//        return "/patient/info/infoPatient";
//    }
//
//    @RequestMapping(value = "/patient/info/edit", method = RequestMethod.POST)
//    public String editPatient(@ModelAttribute("patientEntity") PatientEntity patientEntity, RedirectAttributes redirectAttributes) {
//
////        PatientEntity selected = patientEntity;
//        redirectAttributes.addFlashAttribute("patientEntity", patientEntity);
//        return "redirect:/patient/edit/editPatient";
//    }

    @RequestMapping(value = "/patient/info/infoPatient")
    public ModelAndView info(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                             @RequestParam(required = false, defaultValue = "1") Integer size,@ModelAttribute("patientEntity") PatientEntity patientEntity) {
//        pageable = new PageRequest(pageNumber, size);
//        page = patientService.requestPage(predicate,pageable);
        System.out.print(patientEntity);
        ModelAndView modelView = new ModelAndView("/patient/info/infoPatient");
//        modelView.addObject("totalPages",page.getTotalPages());
//        modelView.addObject("patients",page.getContent());
//        modelView.addObject("pageable",pageable);
//        modelView.addObject("patientEntity",patientEntity);
        return modelView;
    }

    @RequestMapping(value = "/patient/info/edit", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute("patientEntity") PatientEntity patientEntity,
                              RedirectAttributes redirectAttributes,Model model, BindingResult result) {
        PatientEntity finding = (PatientEntity)model.asMap().get("patientEntity");
        System.out.print("model in info:"+finding);
        System.out.print("pe in info:"+patientEntity);
                patientValidator.validate(patientEntity, result);
//        PatientEntity selected = page.getContent().get(0);
//        System.out.print(redirectAttributes.getFlashAttributes());
//        redirectAttributes.addFlashAttribute("patient", selected);
        redirectAttributes.addFlashAttribute("patientEntity", patientEntity);
//        Map>String, ?< flashMap = RequestContextUtils.getInputFlashMap(request);
//        flashMap.get("key");
        return "redirect:/patient/edit/editPatient";
    }

    @RequestMapping(value = "/patient/info/infoPatient", params = {"id"})
    public String requestInfo(@RequestParam(required = true) Long id,
                              ModelMap modelMap) {
        PatientEntity patientEntity = patientService.findOne(id);
        modelMap.addAttribute("patientEntity",patientEntity);
        return "/patient/info/infoPatient";
    }
}
