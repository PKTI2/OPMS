package pl.opms.fe.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.opms.be.entity.BaseEntity;
import pl.opms.be.entity.PrivilegeEntity;
import pl.opms.be.service.PrivilegeService;
import pl.opms.be.service.RoleService;
import pl.opms.utils.role.PrivilegesOutdatedException;
import pl.opms.utils.role.Wrapper;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Dawid on 10.12.2016 at 21:21.
 */

@Controller
public class RolesController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilegeService privilegeService;
    private static final Logger logger = Logger.getLogger(RolesController.class);


    @ModelAttribute("wrapper")
    public Wrapper populateRole() {
        return new Wrapper(roleService.getAll(), privilegeService.getAll());
    }

    @ModelAttribute("allPrivileges")
    public List<PrivilegeEntity> populatePrivilege() {
        List<PrivilegeEntity> privilegeEntities = privilegeService.getAll();
        privilegeEntities.sort(Comparator.comparing(BaseEntity::getId));
        return privilegeEntities;
    }

    @RequestMapping("/admin/roles")
    public String showRoles() {
        return "admin/roles";
    }

    @RequestMapping(value = "/admin/roles/save", method = RequestMethod.POST)
    public String saveRoles(@ModelAttribute("wrapper") Wrapper wrapper, BindingResult result, ModelMap modelMap) {

        try {
            roleService.updateRole(wrapper);
        } catch (NoSuchElementException | PrivilegesOutdatedException e) {
            modelMap.addAttribute("error", true);
            logger.info(e.getMessage());
            return "admin/roles";
        }

        return "redirect:/admin/roles";
    }
}
