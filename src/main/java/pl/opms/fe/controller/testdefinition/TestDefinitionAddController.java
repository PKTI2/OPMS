package pl.opms.fe.controller.testdefinition;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.NodeDefinitionEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.service.TestDefinitionService;
import pl.opms.be.validator.NodeDefinitionValidator;
import pl.opms.be.validator.TestDefinitionValidator;

import java.util.ArrayList;

/**
 * Created by howor on 17.12.2016.
 */

@Controller
@RequestMapping(value = "/test-definition/add")
public class TestDefinitionAddController {

    @Autowired
    private TestDefinitionService testDefinitionService;

    @Autowired
    private TestDefinitionValidator testDefinitionValidator;

    @Autowired
    private NodeDefinitionValidator nodeDefinitionValidator;

    private static final Logger logger = Logger.getLogger(TestDefinitionAddController.class);

    TestDefinitionEntity testDef = new TestDefinitionEntity("", false, new ArrayList<>());

    @ModelAttribute("newNode")
    public NodeDefinitionEntity populateNodeDef() {
        return new NodeDefinitionEntity();
    }

    @ModelAttribute("testDef")
    public TestDefinitionEntity populateTestDef() {
        return testDef;
    }


    @RequestMapping(path = "")
    public String root(@RequestParam(required = false, defaultValue = "false") Boolean success,
                       ModelMap modelMap) {
        if (success) {
            modelMap.addAttribute("success", true);
        }
        return "test-definition/add";
    }

    @RequestMapping(path = "/update", params = {"addNode"}, method = RequestMethod.POST)
    public String addNode(@ModelAttribute("testDef") TestDefinitionEntity testDef,
                          @ModelAttribute("newNode") NodeDefinitionEntity newNode,
                          BindingResult result, ModelMap modelMap,
                          RedirectAttributes redirectAttributes) {
        nodeDefinitionValidator.validate(newNode, result);
        if (result.hasErrors()) {
            return "test-definition/add";
        }

        testDef.getNodeEntities().add(newNode);
        return "test-definition/add";
    }

    @RequestMapping(path = "/update", params = {"removeNode"}, method = RequestMethod.POST)
    public String removeNode(@RequestParam int removeNode) {
        testDef.getNodeEntities().remove(removeNode);
        return "test-definition/add";
    }

    @RequestMapping(path = "/update", params = {"save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute("testDef") TestDefinitionEntity testDef,
                       BindingResult result, ModelMap modelMap,
                       RedirectAttributes redirectAttributes) {
        testDefinitionValidator.validate(testDef, result);
        if (result.hasErrors()) {
            return "test-definition/add";
        }
        testDefinitionService.save(testDef);
        redirectAttributes.addAttribute("success", true);
        return "redirect:/test-definition/add";
    }
}
