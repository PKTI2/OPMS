package pl.opms.fe.controller.role;

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
import pl.opms.be.entity.RoleEntity;
import pl.opms.be.service.PrivilegeService;
import pl.opms.be.service.RoleService;
import pl.opms.be.utils.role.PrivilegesOutdatedException;
import pl.opms.be.utils.role.RoleUtil;
import pl.opms.be.validator.RoleValidator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Dawid on 15.12.2016 at 00:48.
 */

@Controller
@RequestMapping("/admin/roles/create")
public class CreateController {
    @Autowired
    transient private RoleService roleService;
    @Autowired
    transient private PrivilegeService privilegeService;
    @Autowired
    transient private RoleValidator roleValidator;
    private static final Logger logger = Logger.getLogger(ManageController.class);

    @ModelAttribute("role")
    public RoleUtil populateRole() {
        return new RoleUtil(new RoleEntity(-1L, "", new HashSet<>()), privilegeService.getAll());
    }

    @ModelAttribute("allPrivileges")
    public List<PrivilegeEntity> populatePrivilege() {
        List<PrivilegeEntity> privilegeEntities = privilegeService.getAll();
        privilegeEntities.sort(Comparator.comparing(BaseEntity::getId));
        return privilegeEntities;
    }

    @RequestMapping("")
    public String showRoles() {
        return "admin/roles/create";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveRoles(@ModelAttribute("role") RoleUtil roleUtil, BindingResult result, ModelMap modelMap) {

        roleValidator.validate(roleUtil, result);
        if (result.hasErrors()) {
            return "admin/roles/create";
        }

        try {
            roleService.save(roleUtil.getName(), roleUtil.getCurrentPrivilegeIds());
        } catch (PrivilegesOutdatedException e) {
            modelMap.addAttribute("error", true);
            logger.info(e.getMessage());
            return "admin/roles/manage";
        }
        return "redirect:/admin/roles/create";
    }
}
