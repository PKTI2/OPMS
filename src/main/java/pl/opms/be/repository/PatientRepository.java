package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.PatientEntity;

import java.util.List;

/**
 * Created by Val on 2016-11-24.
 */
@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long>{
    //List<PatientEntity> findByUserName(String userName);
}
