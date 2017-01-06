package pl.opms.fe.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.opms.be.entity.StaffEntity;
import pl.opms.be.service.StaffService;

/**
 * Created by Dawid on 30.12.2016 at 22:31.
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;

    @RequestMapping(path = "/profile")
    public String showProfile(@RequestParam(required = false, name = "message") String message, ModelMap modelMap) {
        if (message != null) {
            modelMap.addAttribute("message", message);
        }
        return "staff/profile";
    }


    @RequestMapping(path = "/showData")
    public String showData(@RequestParam(required = false, defaultValue = "false") Boolean success, ModelMap modelMap) {
        StaffEntity staffEntity = staffService.getByUsername(SecurityContextHolder.getContext().getAuthentication()
                .getName());
        if (success) {
            modelMap.addAttribute("success", true);
        }
        modelMap.addAttribute("staff", staffEntity);
        return "staff/showData";
    }
}