package pl.opms.fe.datamodel;


import com.querydsl.core.types.dsl.BooleanExpression;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import pl.opms.be.entity.QTestDefinitionEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.repository.TestDefinitionRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.primefaces.model.SortOrder.ASCENDING;
import static org.primefaces.model.SortOrder.DESCENDING;

/**
 * Created by howor on 03.12.2016.
 */

@Component
@Scope("flow")
public class TestDefinitionCrudDataModel extends org.primefaces.model.LazyDataModel<TestDefinitionEntity> {

    @Autowired
    private transient TestDefinitionRepository testDefinitionRepository;

    @Override
    public Object getRowKey(TestDefinitionEntity object) {
        return object.getId();
    }

    @Override
    public TestDefinitionEntity getRowData(String rowKey) {
        Optional<TestDefinitionEntity> result = ((List<TestDefinitionEntity>)getWrappedData()).stream()
                .filter(p->p.getId().equals(Long.parseLong(rowKey))).findFirst();
        return result.get();
    }

    @Override
    public List<TestDefinitionEntity> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                           Map<String, Object> filters) {
        PageRequest pageRequest = new PageRequest(first/pageSize,pageSize,getSort(sortField,sortOrder));
        QTestDefinitionEntity query = QTestDefinitionEntity.testDefinitionEntity;
        BooleanExpression namePredicate = query.name.contains("");
        BooleanExpression deprecatedPredicate = query.deprecated.isNotNull();
        if(filters.containsKey("name")) {
            String nameFilter = (String) filters.get("name");
            namePredicate = query.name.contains(nameFilter);
        }
        if(filters.containsKey("deprecated")) {
            Boolean deprecatedFilter = (Boolean) filters.get("deprecated");
            deprecatedPredicate = query.deprecated.eq(deprecatedFilter);
        }
        BooleanExpression searchPredicate = namePredicate.and(deprecatedPredicate);
        Page<TestDefinitionEntity> page = testDefinitionRepository.findAll(searchPredicate,pageRequest);
        setRowCount((int)page.getTotalElements());
        setWrappedData(page.getContent());
        return (List<TestDefinitionEntity>) getWrappedData();
    }

    private Sort getSort(String sortField, SortOrder sortOrder) {
        Sort.Direction sortDirection = null;
        if (sortOrder.equals(DESCENDING)) sortDirection = Sort.Direction.DESC;
        if(sortOrder.equals(ASCENDING)) sortDirection = Sort.Direction.ASC;
        if(sortField != null) return new Sort(sortDirection,sortField);
        else return new Sort(sortDirection,"name");
    }


}
