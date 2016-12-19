package pl.opms.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.opms.be.entity.AddingPatientDefinitionEntity;


@Repository
public interface AddingPatientDefinitionRepository extends CrudRepository<AddingPatientDefinitionEntity, Long> {
}