package pl.opms.fe.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.PhoneNumberEntity;
import pl.opms.be.entity.RoleEntity;
import pl.opms.be.entity.StaffEntity;
import pl.opms.be.service.RoleService;
import pl.opms.be.service.StaffService;
import pl.opms.be.utils.generator.PasswordGenerator;
import pl.opms.be.validator.StaffValidator;

import java.util.List;

/**
 * Created by Dawid on 17.12.2016 at 17:06.
 */

@Controller
@RequestMapping("/admin/staff/register")
public class RegisterController {
    @Autowired
    transient private StaffValidator staffValidator;
    @Autowired
    transient private RoleService roleService;
    @Autowired
    transient private StaffService staffService;

    @ModelAttribute("roles")
    public List<RoleEntity> populateRoles() {
        return roleService.getAll();
    }
    private String password = new PasswordGenerator().next();

    @ModelAttribute("staff")
    public StaffEntity populateStaff() {
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setPassword(password);
        return staffEntity;
    }

    @RequestMapping("")
    public String showForm(@RequestParam(required = false, defaultValue = "false") Boolean success, ModelMap modelMap) {
        if(success) {
            modelMap.addAttribute("success", true);
        }
        return "admin/staff/register";
    }


    @RequestMapping(path = "/save", params = {"addPhone"}, method = RequestMethod.POST)
    public String addRow(@ModelAttribute("staff") StaffEntity staffEntity) {
        staffEntity.getPersonalDataEntity().getPhoneNumbers().add(new PhoneNumberEntity());
        return "admin/staff/register";
    }


    @RequestMapping(path = "/save", params = {"removePhone"})
    public String removeRow(@RequestParam(value = "removePhone", required = false, defaultValue = "0") int index,
                            @ModelAttribute("staff") StaffEntity staffEntity) {
        if (index >= 0 && index < staffEntity.getPersonalDataEntity().getPhoneNumbers().size()) {
            staffEntity.getPersonalDataEntity().getPhoneNumbers().remove(index);
        }
        return "admin/staff/register";
    }


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveStaff(@ModelAttribute("staff") StaffEntity staffEntity, BindingResult result, ModelMap modelMap,
                            RedirectAttributes redirectAttributes) {
        System.out.println(staffEntity.getPersonalDataEntity().getBirthDate());
        staffValidator.validate(staffEntity, result);
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return "admin/staff/register";
            //TODO walidacja czy staff juz istnieje
        }


        try {
            System.out.println(staffEntity);
            staffService.save(staffEntity);
        } catch (Exception e) {
            modelMap.addAttribute("error", true);
            return "admin/staff/register";
        }

        redirectAttributes.addAttribute("success", true);
        return "redirect:/admin/staff/register";
    }
}