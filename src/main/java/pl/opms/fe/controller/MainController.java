package pl.opms.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.UserEntity;
import pl.opms.be.model.PasswordToChange;
import pl.opms.be.service.StaffService;
import pl.opms.be.service.UserService;
import pl.opms.be.validator.PasswordValidator;

/**
 * Created by Piotr Borczyk on 07.12.2016.
 */
@Controller
@SessionAttributes("passwords")
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordValidator passwordValidator;
    @Autowired
    private StaffService staffService;

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/profile")
    public String redirectToProfile() {
        if (staffService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) != null) {
            return "redirect:/staff/profile";
        }
        return "index";
    }


    @RequestMapping("/index")
    public String index(@RequestParam(required = false, defaultValue = "false") Boolean success, RedirectAttributes redirectAttributes,
                        ModelMap modelMap) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity.getPasswordExpired()) {
            redirectAttributes.addFlashAttribute("user", userEntity);
            return "redirect:/resetPassword";
        }

        if (success) {
            modelMap.addAttribute("success", true);
        }

        return "index";
    }

    @RequestMapping(path = "/resetPassword/save", method = RequestMethod.POST)
    public String saveNewPassword(@ModelAttribute("passwords") PasswordToChange passwordToChange, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, ModelMap modelMap, SessionStatus status) {
        passwordValidator.validate(passwordToChange, bindingResult);
        if (bindingResult.hasErrors()) {
            return "resetPassword";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity = userService.findByUsername(username);
        userEntity.setPassword(passwordToChange.getNewPassword());
        userEntity.setPasswordExpired(false);

        try {
            userService.save(userEntity);
        } catch (Exception e) {
            modelMap.addAttribute("error", true);
            return "resetPassword";
        }

        status.setComplete();
        redirectAttributes.addAttribute("success", true);
        return "redirect:/index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/resetPassword")
    public String showResetPassword(Model model) {
        UserEntity userEntity = (UserEntity) model.asMap().get("user");
        PasswordToChange passwordToChange = new PasswordToChange();
        passwordToChange.setActualPassword(userEntity.getPassword());
        model.addAttribute("passwords", passwordToChange);
        return "/resetPassword";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin() {
        // TODO Enable form login with Spring Security (trigger error for now)
        return "redirect:/login-error";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
