package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.RoleEntity;
import pl.opms.be.entity.UserEntity;

/**
 * Created by Dawid on 10.12.2016 at 14:59.
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
