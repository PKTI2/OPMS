package pl.opms.fe.controller.patient;

import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.QPatientEntity;
import pl.opms.be.entity.QTestDefinitionEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.service.TestDefinitionService;
import pl.opms.fe.controller.testdefinition.TestDefinitionCrudController;

import javax.annotation.PostConstruct;

/**
 * Created by Adam on 2017-01-02.
 */
@Controller
public class FindPatientController {

    @Autowired
    transient private PatientService patientService;


    private Pageable pageable;
    private Page<PatientEntity> page;
    private Predicate predicate;

    @Getter
    @Setter
    public static class SearchBean {
        String searchTerm = "";
        String searchTermFirstName = "";
        String searchTermLastName = "";
        String searchTermPeselNumber = "";
        Boolean isEnabled = true;
    }

    SearchBean searchBean = new SearchBean();

    @PostConstruct
    public void init() {
        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;
        predicate = qPatientEntity.patientEntity.personalDataEntity.firstName.contains("");
    }

    @RequestMapping(value = "/patient/find", method = RequestMethod.GET)
    public ModelAndView find(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                             @RequestParam(required = false, defaultValue = "10") Integer size) {
        pageable = new PageRequest(pageNumber, size);
        page = patientService.requestPage(predicate,pageable);
        ModelAndView modelView = new ModelAndView("/patient/find/findPatient");
        modelView.addObject("totalPages",page.getTotalPages());
        modelView.addObject("patients",page.getContent());
        modelView.addObject("pageable",pageable);
        modelView.addObject("searchBean",searchBean);
        return modelView;
    }

//    @RequestMapping(value = "/patient/find/searchByFirstName", method = RequestMethod.POST)
//    public ModelAndView searchByFirstName(@ModelAttribute SearchBean searchBean) {
//        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;
//        predicate = qPatientEntity.personalDataEntity.firstName.contains(searchBean.getSearchTermFirstName());
//        ModelAndView modelAndView = new ModelAndView("redirect:/patient/find");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/patient/find/searchByLastName", method = RequestMethod.POST)
//    public ModelAndView searchByLastName(@ModelAttribute SearchBean searchBean) {
//        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;
//        predicate = qPatientEntity.personalDataEntity.lastName.contains(searchBean.getSearchTermLastName());
//        ModelAndView modelAndView = new ModelAndView("redirect:/patient/find");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/patient/find/searchByPeselNumber", method = RequestMethod.POST)
//    public ModelAndView searchByPeselNumber(@ModelAttribute SearchBean searchBean) {
//        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;
//        predicate = qPatientEntity.personalDataEntity.peselNumber.contains(searchBean.getSearchTermPeselNumber());
//        ModelAndView modelAndView = new ModelAndView("redirect:/patient/find");
//        return modelAndView;
//    }

    @RequestMapping(value = "/patient/find/searchByAll", method = RequestMethod.POST)
    public ModelAndView searchByAll(@ModelAttribute SearchBean searchBean) {
        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;
        predicate = qPatientEntity.personalDataEntity.peselNumber.contains(searchBean.getSearchTerm()).or(qPatientEntity.personalDataEntity.lastName.contains(searchBean.getSearchTerm()).or(qPatientEntity.personalDataEntity.firstName.contains(searchBean.getSearchTerm())));

        ModelAndView modelAndView = new ModelAndView("redirect:/patient/find");
        return modelAndView;
    }


    @RequestMapping(value = "/patient/find/table", method = RequestMethod.POST)
    public ModelAndView showPatient(@RequestParam(required = true) Integer rowIndex,
                                 RedirectAttributes redirectAttributes) {

        PatientEntity selected = page.getContent().get(rowIndex);
        System.out.print("selected in find: "+selected+"\n");
        redirectAttributes.addFlashAttribute("patientEntity", selected);
//        return "redirect:/patient/info/infoPatient";
        return new ModelAndView("redirect:/patient/info/infoPatient");
    }
}


//http://www.mkyong.com/spring-mvc/spring-4-mvc-ajax-hello-world-example/