package pl.opms.fe.controller.patient;


import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.QPatientEntity;

import javax.annotation.PostConstruct;


/**
 * Created by Adam on 2017-01-02.
 */
@Controller
public class InfoPatientController {

    private Pageable pageable;
    private Page<PatientEntity> page;
    private Predicate predicate;

    @PostConstruct
    public void init() {
        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;
        predicate = qPatientEntity.patientEntity.personalDataEntity.firstName.contains("");

    }

    @RequestMapping(value = "/patient/info/infoPatient")
    public String info(Model model) {
        return "/patient/info/infoPatient";
    }

    @RequestMapping(value = "/patient/info/edit", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute("patientEntity") PatientEntity patientEntity, RedirectAttributes redirectAttributes) {

//        PatientEntity selected = patientEntity;
        redirectAttributes.addFlashAttribute("patientEntity", patientEntity);
        return "redirect:/patient/edit/editPatient";
    }
}
