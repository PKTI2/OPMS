package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.UserEntity;

/**
 * Created by Dawid on 29.11.2016 at 20:44.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
