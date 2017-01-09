package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.PersonalDataEntity;
import pl.opms.be.entity.RoomEntity;
import pl.opms.be.repository.PatientRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Val on 2016-12-13.
 */
@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientEntity> getByFirstName(String firstname){return patientRepository.findByPersonalDataEntityFirstName(firstname);}
    public List<PatientEntity> getByLastName(String lastname){return patientRepository.findByPersonalDataEntityLastName(lastname);}
    public List<PatientEntity> getByPeselNumber(String peselnumber){return patientRepository.findByPersonalDataEntityPeselNumber(peselnumber);}
//    public List<PatientEntity> getByUsername(String username){return staffRepository.findByUsername(username);}

    public Page<PatientEntity> requestPage(Pageable pageRequest) {return patientRepository.findAll(pageRequest);}
    public Page<PatientEntity> requestPage(Predicate predicate, Pageable pageRequest) {return patientRepository.findAll(predicate, pageRequest);}

    public void save(PatientEntity patientEntity) {
        patientRepository.save(patientEntity);
    }

    public PatientEntity findOne(Long patientId) {
        return patientRepository.findOne(patientId);
}

    public Iterable<PatientEntity> findAll(Predicate predicate) {
        return patientRepository.findAll(predicate);
    }

}