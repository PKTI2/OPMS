package pl.opms.be.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.PatientEntity;

import java.util.List;

/**
 * Created by Val on 2016-11-24.
 */
@Repository
public interface PatientRepository extends PagingAndSortingRepository<PatientEntity, Long>,
        QueryDslPredicateExecutor<PatientEntity>,CrudRepository<PatientEntity, Long> {

    List<PatientEntity> findByPersonalDataEntityFirstName(String firstname);
    List<PatientEntity> findByPersonalDataEntityLastName(String lastname);
    List<PatientEntity> findByPersonalDataEntityPeselNumber(String peselnumber);
//    findByUsername(String username);


}
