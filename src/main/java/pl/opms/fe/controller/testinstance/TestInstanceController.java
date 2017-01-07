package pl.opms.fe.controller.testinstance;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.entity.TestInstanceEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.service.TestDefinitionService;
import pl.opms.be.service.TestInstanceService;
import pl.opms.be.validator.TestInstanceValidator;

/**
 * Created by howor on 29.12.2016.
 */

@Controller
@RequestMapping(value = "/test-instance")
@SessionAttributes("newInstance")
public class TestInstanceController {

    @Autowired
    private TestInstanceService testInstanceService;

    @Autowired
    private TestDefinitionService testDefinitionService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private TestInstanceValidator testInstanceValidator;

    private static final Logger logger = Logger.getLogger(TestInstanceController.class);

    private PatientEntity patientEntity;

    @RequestMapping(path = "/display")
    public String display(@RequestParam(required = true) Long id,
                          ModelMap modelMap) {
        TestInstanceEntity testInstanceEntity = testInstanceService.findOne(id);

        if(testInstanceEntity != null) {
            modelMap.addAttribute("testInstance",testInstanceEntity);
        }
        return "/test-instance/display";
    }

    @RequestMapping(path = "/add")
    public String add(@RequestParam(required = true) Long definitionId,
                      @RequestParam(required = true) Long patientId,
                      ModelMap modelMap) {
        patientEntity = patientService.findOne(patientId);
        TestDefinitionEntity testDefinitionEntity = testDefinitionService.findOne(definitionId);
        TestInstanceEntity newInstance = new TestInstanceEntity(testDefinitionEntity);
        modelMap.addAttribute("newInstance",newInstance);
        modelMap.addAttribute("patientName",patientEntity.getPersonalDataEntity().getFirstName() +
                " " + patientEntity.getPersonalDataEntity().getLastName());
        return "/test-instance/add";
    }

    @RequestMapping(path = "/add" ,params = {"save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute("newInstance") TestInstanceEntity newInstance,
                       BindingResult result, ModelMap modelMap,
                       RedirectAttributes redirectAttributes) {
        testInstanceValidator.validate(newInstance, result);
        if (result.hasErrors()) {
            return "test-instance/add";
        }
        try {
            patientEntity.getTests().add(newInstance);
            testInstanceService.save(newInstance);
            patientService.save(patientEntity);
            return "redirect:/test-instance/add/success";
        }catch (Exception e) {
            modelMap.addAttribute("error", true);
            logger.info(e.getMessage());
            return "test-instance/add";
        }
    }

    @RequestMapping(path = "/add/success")
    public String success(ModelMap modelMap) {
        modelMap.addAttribute("success",true);
        return "test-instance/add";
    }

    @RequestMapping(path = "/add/error")
    public String error(ModelMap modelMap) {
        modelMap.addAttribute("success",true);
        return "test-instance/add";
    }
}
