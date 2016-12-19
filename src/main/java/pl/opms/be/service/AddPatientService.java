package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.opms.be.repository.PatientRepository;

/**
 * Created by Val on 2016-12-13.
 */
@Service
public class AddPatientService {

    @Autowired
    private PatientRepository patientRepository;


}
