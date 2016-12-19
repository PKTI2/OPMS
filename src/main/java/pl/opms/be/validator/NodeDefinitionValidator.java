package pl.opms.be.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.opms.be.entity.NodeDefinitionEntity;

/**
 * Created by Piotr Borczyk on 19.12.2016.
 */

@Component
public class NodeDefinitionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(NodeDefinitionEntity.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NodeDefinitionEntity nodeDefinitionEntity = (NodeDefinitionEntity) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"label","emptyNodeLabel");
        if(nodeDefinitionEntity.getNodeType() == null) errors.rejectValue("nodeType","nodeTypeNull");
    }
}
