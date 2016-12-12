package pl.opms.be.service;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.repository.TestDefinitionRepository;

/**
 * Created by Piotr Borczyk on 12.12.2016.
 */

@Service
public class TestDefinitionService {

    @Autowired
    private TestDefinitionRepository testDefinitionRepository;

    public Page<TestDefinitionEntity> requestPage(Pageable pageRequest) {
        return testDefinitionRepository.findAll(pageRequest);
    }

    public Page<TestDefinitionEntity> requestPage(Predicate predicate, Pageable pageRequest) {
        return testDefinitionRepository.findAll(predicate,pageRequest);
    }
}
