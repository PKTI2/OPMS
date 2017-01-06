package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.opms.be.entity.StaffEntity;
import pl.opms.be.service.StaffService;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

/**
 * Created by Dawid on 17.12.2016 at 17:15.
 */

@Component
public class StaffValidator implements Validator {
    @Autowired
    private StaffService staffService;
    @Autowired
    private BasicStaffValidator basicStaffValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return StaffEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StaffEntity staffEntity = (StaffEntity) o;
        basicStaffValidator.validate(staffEntity, errors);
        rejectIfEmptyOrWhitespace(errors, "medicalTitle", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "username", "registration.form.empty");

        if (!staffEntity.getUsername().equals("")) {
            if (!staffService.isUsernameFree(staffEntity.getUsername())) {
                errors.rejectValue("username","registration.form.username.busy");
            }
        }
    }
}
