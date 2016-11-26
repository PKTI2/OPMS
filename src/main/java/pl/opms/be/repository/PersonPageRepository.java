package pl.opms.be.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.PersonEntity;


/**
 * Created by Piotr Borczyk on 15.11.2016.
 */

@Repository
public interface PersonPageRepository extends PagingAndSortingRepository<PersonEntity, Long> {
    //findAll() Jest domyślnie dostępna
}
