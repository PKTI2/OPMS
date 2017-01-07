package pl.opms.fe.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PhoneNumberEntity;
import pl.opms.be.entity.StaffEntity;
import pl.opms.be.service.StaffService;
import pl.opms.be.validator.BasicStaffValidator;
import pl.opms.be.validator.StaffValidator;

/**
 * Created by Dawid on 06.01.2017 at 12:56.
 */
@Controller
@RequestMapping("/staff/editData")
@SessionAttributes("staff")
public class EditDataController {
    @Autowired
    private BasicStaffValidator basicStaffValidator;
    @Autowired
    private StaffService staffService;

    @RequestMapping("")
    public String showForm(ModelMap modelMap) {
        StaffEntity staffEntity = staffService.getByUsername(SecurityContextHolder.getContext().getAuthentication()
                .getName());
        modelMap.addAttribute("staff", staffEntity);
        return "staff/editData";
    }


    @RequestMapping(path = "/save", params = {"addPhone"}, method = RequestMethod.POST)
    public String addRow(@ModelAttribute("staff") StaffEntity staffEntity) {
        staffEntity.getPersonalDataEntity().getPhoneNumbers().add(new PhoneNumberEntity());
        return "staff/editData";
    }


    @RequestMapping(path = "/save", params = {"removePhone"})
    public String removeRow(@RequestParam(value = "removePhone", required = false, defaultValue = "0") int index,
                            @ModelAttribute("staff") StaffEntity staffEntity) {
        if (index >= 0 && index < staffEntity.getPersonalDataEntity().getPhoneNumbers().size()) {
            staffEntity.getPersonalDataEntity().getPhoneNumbers().remove(index);
        }
        return "staff/editData";
    }


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveStaff(@ModelAttribute("staff") StaffEntity staffEntity, BindingResult result, ModelMap modelMap,
                            RedirectAttributes redirectAttributes, SessionStatus status) {
        basicStaffValidator.validate(staffEntity, result);
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return "staff/editData";
        }

        try {
            System.out.println(staffEntity);
            staffService.update(staffEntity);
        } catch (Exception e) {
            modelMap.addAttribute("error", true);
            return "staff/editData";
        }

        status.setComplete();
        redirectAttributes.addAttribute("success", true);
        return "redirect:/staff/showData";
    }
}
