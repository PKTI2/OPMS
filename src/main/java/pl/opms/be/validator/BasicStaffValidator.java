package pl.opms.be.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.opms.be.entity.StaffEntity;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

/**
 * Created by Dawid on 06.01.2017 at 14:40.
 */
@Component
public class BasicStaffValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return StaffEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StaffEntity staffEntity = (StaffEntity) o;
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.firstName", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.lastName", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.peselNumber", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.birthDate", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.address.street", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.address.city", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.address.country", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "personalDataEntity.address.postalCode", "registration.form.empty");
        rejectIfEmptyOrWhitespace(errors, "medicalTitle", "registration.form.empty");

        if (staffEntity.getPersonalDataEntity().getIsMailAddress()) {
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.street", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.city", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.country", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.postalCode", "registration.form.empty");
        }
    }
}
