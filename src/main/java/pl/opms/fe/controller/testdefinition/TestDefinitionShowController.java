package pl.opms.fe.controller.testdefinition;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Piotr Borczyk on 19.12.2016.
 */

@Controller
@RequestMapping("/test-definition/show")
public class TestDefinitionShowController {
    @RequestMapping(path = "")
    public String show(Model model) {
        return "/test-definition/show";
    }
}
