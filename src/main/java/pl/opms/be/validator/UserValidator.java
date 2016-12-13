package pl.opms.be.validator;

/**
 * Created by Dawid on 10.12.2016 at 15:17.
 */

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.opms.be.entity.UserEntity;

public class UserValidator implements Validator {
    @Override

    public boolean supports(Class clazz) {
        return UserEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // walidacja forumularza
    }
}
