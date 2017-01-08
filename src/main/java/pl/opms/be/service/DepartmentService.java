package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.opms.be.entity.DepartmentEntity;
import pl.opms.be.repository.DepartmentRepository;

/**
 * Created by howor on 08.01.2017.
 */

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity findOne(Long id) {
        return departmentRepository.findOne(id);
    }
}
