package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.opms.be.entity.NodeInstanceEntity;
import pl.opms.be.entity.TestInstanceEntity;

/**
 * Created by howor on 30.12.2016.
 */

@Component
public class TestInstanceValidator implements Validator {

    @Autowired
    private NodeInstanceValidator nodeInstanceValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(TestInstanceEntity.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TestInstanceEntity testInstanceEntity = (TestInstanceEntity) o;

        try {
            errors.pushNestedPath("node");
            for (NodeInstanceEntity nodeInstanceEntity : testInstanceEntity.getNodes()) {
                ValidationUtils.invokeValidator(nodeInstanceValidator, nodeInstanceEntity, errors);
            }
        }
        finally {
            errors.popNestedPath();
        }

    }
}
