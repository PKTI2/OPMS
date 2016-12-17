package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.opms.be.service.RoleService;
import pl.opms.be.utils.role.RoleUtil;

/**
 * Created by Dawid on 16.12.2016 at 20:13.
 */

@Component
public class RoleValidator implements Validator{
    @Autowired
    private RoleService roleService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RoleUtil.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RoleUtil roleUtil = (RoleUtil)o;
        ValidationUtils.rejectIfEmpty(errors, "name", "empty");
        if (roleService.getByName(roleUtil.getName()).size() > 0) {
            errors.reject("name.already.exist");
        }
    }
}
