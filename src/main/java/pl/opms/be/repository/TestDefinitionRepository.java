package pl.opms.be.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.TestDefinitionEntity;

/**
 * Created by Dawid on 22.11.2016 at 18:46.
 */
@Repository
public interface TestDefinitionRepository extends PagingAndSortingRepository<TestDefinitionEntity, Long>,
        QueryDslPredicateExecutor<TestDefinitionEntity> {

}
