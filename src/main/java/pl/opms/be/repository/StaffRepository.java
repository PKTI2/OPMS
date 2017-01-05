package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.StaffEntity;

/**
 * Created by Dawid on 17.12.2016 at 17:09.
 */
@Repository
public interface StaffRepository extends CrudRepository<StaffEntity, Long>{
    StaffEntity findByUsername(String username);
}
