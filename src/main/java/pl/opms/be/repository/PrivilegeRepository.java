package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.PrivilegeEntity;

import java.util.List;

/**
 * Created by Dawid on 10.12.2016 at 21:47.
 */

@Repository
public interface PrivilegeRepository extends CrudRepository<PrivilegeEntity, Long> {
    List<PrivilegeEntity> findAll();
}
