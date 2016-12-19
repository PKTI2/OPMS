package pl.opms.be.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.service.TestDefinitionService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Piotr Borczyk on 19.12.2016.
 */

@Component
public class TestDefinitionValidator implements Validator {

    @Autowired
    private TestDefinitionService testDefinitionService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(TestDefinitionEntity.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TestDefinitionEntity testDefinitionEntity = (TestDefinitionEntity) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","emptyName");
        if (CollectionUtils.isEmpty(testDefinitionEntity.getNodeEntities())) {
            errors.rejectValue("nodeEntities","noNodes");
        }
        if (checkForDuplicateNodes(testDefinitionEntity.getNodeEntities())) {
            errors.rejectValue("nodeEntities", "duplicateNodes");
        }

        if(alreadyExists(testDefinitionEntity)) {
            errors.rejectValue("name","testDefinitionAlreadyExists");
        }
    }

    private boolean checkForDuplicateNodes(List<?> list) {
        Set<Object> checkSet = new HashSet<>();
        for(Object object : list) {
            if(!checkSet.add(object)) return true;
        }
        return false;
    }

    private boolean alreadyExists(TestDefinitionEntity testDefinitionEntity) {
        long count = testDefinitionService.countByName(testDefinitionEntity.getName());
        if(count > 0) return true;
        else return false;
    }
}
