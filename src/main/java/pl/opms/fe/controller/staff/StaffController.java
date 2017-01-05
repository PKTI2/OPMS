package pl.opms.fe.controller.staff;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Dawid on 30.12.2016 at 22:31.
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @RequestMapping(path = "/profile")
    public String showProfile(@RequestParam(required = false, name = "message") String message, ModelMap modelMap) {
        if (message != null) {
            modelMap.addAttribute("message", message);
        }
        return "staff/profile";
    }


    @RequestMapping(path = "/showData")
    public String showData() {
        return "staff/showData";
    }
}