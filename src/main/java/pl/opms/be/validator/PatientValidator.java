package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.service.PatientService;


import static org.springframework.validation.ValidationUtils.rejectIfEmpty;

/**
 * Created by Adam on 2017-01-08.
 */
@Component
public class PatientValidator implements Validator {
//    @Autowired
//    private PatientService patientService;

    @Override
    public boolean supports(Class<?> aClass) {
        return PatientEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PatientEntity patientEntity = (PatientEntity) o;
        rejectIfEmpty(errors, "personalDataEntity.firstName", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.lastName", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.peselNumber", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.birthDate", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.street", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.city", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.country", "registration.form.empty");
        rejectIfEmpty(errors, "personalDataEntity.address.postalCode", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.weight", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.height", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.bloodType", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.bloodAntigen", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.gender", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.department", "registration.form.empty");
        rejectIfEmpty(errors, "patientData.room", "registration.form.empty");


        if(patientEntity.getPersonalDataEntity().getIsMailAddress()) {
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.street", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.city", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.country", "registration.form.empty");
            rejectIfEmpty(errors, "personalDataEntity.mailAddress.postalCode", "registration.form.empty");

        }

//        rejectIfEmpty(errors, "patientData.department", "registration.form.empty");
//        rejectIfEmpty(errors, "patientData.room", "registration.form.empty");
    }
}