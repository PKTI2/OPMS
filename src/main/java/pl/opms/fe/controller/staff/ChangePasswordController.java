package pl.opms.fe.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.UserEntity;
import pl.opms.be.model.PasswordToChange;
import pl.opms.be.service.UserService;
import pl.opms.be.validator.PasswordValidator;

/**
 * Created by Dawid on 31.12.2016 at 00:09.
 */
@Controller
@RequestMapping("/staff/password/change")
@SessionAttributes("passwords")
public class ChangePasswordController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordValidator passwordValidator;

    @RequestMapping("")
    public String showPasswordChange(ModelMap model) {
        PasswordToChange passwordToChange = new PasswordToChange();
        passwordToChange.setActualPassword(userService.findByUsername(SecurityContextHolder.getContext()
                .getAuthentication().getName()).getPassword());
        model.addAttribute("passwords", passwordToChange);
        return "staff/passwordChange";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveChangedPassword(@ModelAttribute("passwords") PasswordToChange passwordToChange, BindingResult result,
                                      RedirectAttributes attributes, ModelMap model, SessionStatus status) {
        passwordValidator.validate(passwordToChange, result);
        if (result.hasErrors()) {
            return "staff/passwordChange";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity = userService.findByUsername(username);
        userEntity.setPassword(passwordToChange.getNewPassword());


        try {
            userService.save(userEntity);
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "resetPassword";
        }

        status.setComplete();
        attributes.addAttribute("message", "Hasło zmieniono pomyślnie");
        return "redirect:/staff/profile";
    }
}
