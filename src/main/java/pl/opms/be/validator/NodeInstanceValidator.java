package pl.opms.be.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.opms.be.entity.NodeInstanceEntity;

/**
 * Created by howor on 30.12.2016.
 */

@Component
public class NodeInstanceValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(NodeInstanceEntity.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NodeInstanceEntity nodeInstanceEntity = (NodeInstanceEntity) o;

        switch (nodeInstanceEntity.getNodeDefinition().getNodeType()) {
            case INT:
                if(nodeInstanceEntity.getIntValue() == null) {
                    errors.reject("intValue","notFilled");
                }
                break;
            case STRING:
                if(nodeInstanceEntity.getStringValue() == null) {
                    errors.reject("stringValue","notFilled");
                }
                break;

            case DOUBLE:
                if(nodeInstanceEntity.getDoubleValue() == null) {
                    errors.reject("doubleValue","notFilled");
                }
                break;

            case BOOL_CHECK_BOX:
                if(nodeInstanceEntity.getBooleanValue() == null) {
                    errors.reject("booleanValue","notFilled");
                }
                break;
        }

    }
}
