package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.opms.be.entity.StaffEntity;
import pl.opms.be.service.StaffService;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;

/**
 * Created by Dawid on 17.12.2016 at 17:15.
 */

@Component
public class StaffValidator implements Validator {
    @Autowired
    private StaffService staffService;

    @Override
    public boolean supports(Class<?> aClass) {
        return StaffEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StaffEntity staffEntity = (StaffEntity) o;
        rejectIfEmpty(errors, "personalDataEntity.firstName", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.lastName", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.peselNumber", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.birthDate", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.street", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.city", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.country", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.postalCode", "registration.form.empty");
        rejectIfEmpty(errors, "medicalTitle", "registration.form.empty");
        rejectIfEmpty(errors, "username", "registration.form.empty");

        if(staffEntity.getPersonalDataEntity().getIsMailAddress()) {
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.street", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.city", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.country", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.postalCode", "registration.form.empty");

        }
    }
}
