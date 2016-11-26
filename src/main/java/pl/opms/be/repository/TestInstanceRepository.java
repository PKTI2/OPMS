package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.TestInstanceEntity;

/**
 * Created by Dawid on 26.11.2016 at 16:24.
 */
@Repository
public interface TestInstanceRepository extends CrudRepository<TestInstanceEntity, Long> {

}
