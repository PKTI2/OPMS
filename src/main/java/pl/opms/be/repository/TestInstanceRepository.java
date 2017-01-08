package pl.opms.be.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.TestInstanceEntity;

/**
 * Created by Dawid on 26.11.2016 at 16:24.
 */
@Repository
public interface TestInstanceRepository extends PagingAndSortingRepository<TestInstanceEntity, Long>,
        QueryDslPredicateExecutor<TestInstanceEntity> {

}
