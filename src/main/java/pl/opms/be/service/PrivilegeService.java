package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.opms.be.entity.PrivilegeEntity;
import pl.opms.be.repository.PrivilegeRepository;

import java.util.List;

/**
 * Created by Dawid on 10.12.2016 at 21:51.
 */
@Service
@Transactional
public class PrivilegeService {
    @Autowired
    private PrivilegeRepository privilegeRepository;

    public List<PrivilegeEntity> getAll() {
        return privilegeRepository.findAll();
    }

    public PrivilegeEntity get(Long id) {
        return privilegeRepository.findOne(id);
    }
}
