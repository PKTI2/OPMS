package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.opms.be.entity.TestInstanceEntity;
import pl.opms.be.repository.TestInstanceRepository;

/**
 * Created by howor on 30.12.2016.
 */

@Service
public class TestInstanceService {

    @Autowired
    private TestInstanceRepository testInstanceRepository;

    public TestInstanceEntity findOne(Long id) {
        return testInstanceRepository.findOne(id);
    }

    public void save(TestInstanceEntity testInstanceEntity) {
        testInstanceRepository.save(testInstanceEntity);
    }
}
