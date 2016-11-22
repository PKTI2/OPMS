package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.PersonEntity;

import java.util.List;


/**
 * Created by Piotr Borczyk on 15.11.2016.
 */

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Long> {
    List<PersonEntity> findByLastname(String lastname);
    List<PersonEntity> findByFirstname(String firstname);
}
