package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.opms.be.entity.StaffEntity;
import pl.opms.be.repository.PrivilegeRepository;
import pl.opms.be.repository.StaffRepository;

/**
 * Created by Dawid on 17.12.2016 at 17:09.
 */
@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void save(StaffEntity staffEntity) {
        staffEntity.setPassword(passwordEncoder.encode(staffEntity.getPassword()));
        staffRepository.save(staffEntity);
    }

    public StaffEntity getByUsername(String username) {
        return staffRepository.findByUsername(username);
    }

    public boolean isUsernameFree(String username) {
        return staffRepository.findByUsername(username) == null;
    }

    public void update(StaffEntity staffEntity) {
        staffRepository.save(staffEntity);
    }
}
