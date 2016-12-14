package pl.opms.be.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.opms.be.entity.PrivilegeEntity;
import pl.opms.be.entity.RoleEntity;
import pl.opms.be.repository.RoleRepository;
import pl.opms.utils.role.PrivilegesOutdatedException;
import pl.opms.utils.role.RoleUtil;
import pl.opms.utils.role.Wrapper;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Dawid on 10.12.2016 at 21:24.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeService privilegeService;


    public List<RoleEntity> getAll() {
        return roleRepository.findAll();
    }

    public RoleEntity get(Long id) {
        return roleRepository.findOne(id);
    }


    public void updateRole(Wrapper wrapper) throws NoSuchElementException, PrivilegesOutdatedException {
        List<RoleUtil> roleUtils = wrapper.getRoles();

        for (RoleUtil roleUtil : roleUtils) {
            RoleEntity roleEntity = roleRepository.findOne(roleUtil.getId());

            if (roleEntity == null) {
                throw new NoSuchElementException("Role id = " + roleUtil.getId() + " was not exist");
            }

            roleEntity.getPrivilegeEntities().clear();

            List<Long> ids = roleUtil.getCurrentPrivilegeIds();

            for (Long id : ids) {
                PrivilegeEntity privilegeEntity = privilegeService.get(id);
                if (privilegeEntity == null) {
                    throw new PrivilegesOutdatedException("Used privileges are outdated");
                }
                roleEntity.getPrivilegeEntities().add(privilegeEntity);
            }

            roleRepository.save(roleEntity);
        }
    }
}
