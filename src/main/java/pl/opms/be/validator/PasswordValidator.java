package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.opms.be.model.PasswordToChange;

/**
 * Created by Dawid on 30.12.2016 at 16:01.
 */
@Component
public class PasswordValidator implements Validator {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return PasswordToChange.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PasswordToChange passwordToChange = (PasswordToChange) o;

        if(!bCryptPasswordEncoder.matches(passwordToChange.getActualPasswordConfirmed(), passwordToChange.getActualPassword())) {
            errors.rejectValue("actualPasswordConfirmed", "reset.password.form.confirm.actual.password.incorrect");
        }

        if(bCryptPasswordEncoder.matches(passwordToChange.getNewPassword(), passwordToChange.getActualPassword())) {
            errors.rejectValue("newPassword", "reset.password.form.confirm.new.password.the.same.like.old.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "registration.form.empty");

        if(!passwordToChange.getNewPassword().equals(passwordToChange.getConfirmNewPassword())) {
            errors.rejectValue("confirmNewPassword", "reset.password.form.confirm.new.password.incorrect");
        }


//        if(!(passwordToChange.getNewPassword()
//                .matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"))) {
//            errors.rejectValue("newPassword", "reset.password.form.new.password.to.weak");
//        }



    }
}
