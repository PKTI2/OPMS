package pl.opms.fe.controller.testinstance;

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
import pl.opms.be.entity.QTestDefinitionEntity;
import pl.opms.be.entity.QTestInstanceEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.entity.TestInstanceEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.service.TestInstanceService;
import pl.opms.fe.controller.testdefinition.TestDefinitionCrudController;

import javax.annotation.PostConstruct;

/**
 * Created by howor on 07.01.2017.
 */

@Controller
@RequestMapping(value = "/test-instance/browse")
public class TestInstanceBrowseController {

    @Autowired
    PatientService patientService;

    PatientEntity patientEntity;

    @Getter
    @Setter
    public static class SearchBean {

    }

    SearchBean searchBean = new SearchBean();

    @PostConstruct
    public void init() {
        QTestInstanceEntity qTestInstanceEntity = QTestInstanceEntity.testInstanceEntity;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView crud(@RequestParam(required = true) Long patientId) {
        ModelAndView modelView = new ModelAndView("/test-instance/browse");
        patientEntity = patientService.findOne(patientId);
        modelView.addObject("patientEntity",patientEntity);
        modelView.addObject("testInstances",patientEntity.getTests());
        return modelView;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute TestDefinitionCrudController.SearchBean searchBean) {
        ModelAndView modelAndView = new ModelAndView("redirect:/test-definition/crud");
        return modelAndView;
    }

    @RequestMapping(path = "/open", method = RequestMethod.POST)
    public String showDefinition(@RequestParam(required = true) Integer rowIndex,
                                 RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("testInstance",patientEntity.getTests().get(rowIndex));
        return "redirect:/test-instance/display";
    }

}
