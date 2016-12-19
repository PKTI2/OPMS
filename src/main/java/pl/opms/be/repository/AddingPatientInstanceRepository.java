package pl.opms.be.repository;

        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import pl.opms.be.entity.AddingPatientInstanceEntity;

@Repository
public interface AddingPatientInstanceRepository extends CrudRepository<AddingPatientInstanceEntity, Long> {

}