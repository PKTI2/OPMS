package pl.opms.be.utils.role;

import lombok.Data;
import lombok.ToString;
import pl.opms.be.entity.BaseEntity;
import pl.opms.be.entity.PrivilegeEntity;
import pl.opms.be.entity.RoleEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Dawid on 11.12.2016 at 01:03.
 */
@Data
@ToString
public class RoleUtil {
    private List<Boolean> hasPermissions;
    private List<Long> ids;
    private long id;
    private String name;

    public RoleUtil(RoleEntity roleEntity, List<PrivilegeEntity> allPrivilegeEntities) {
        this.id = roleEntity.getId();
        this.name = roleEntity.getName();
        this.hasPermissions = new ArrayList<>();
        this.ids = new ArrayList<>();

        initHasPermissions(roleEntity, allPrivilegeEntities);
    }

    private void initHasPermissions(RoleEntity roleEntity, List<PrivilegeEntity> allPrivilegeEntities){
        List<PrivilegeEntity> currentPrivileges = new ArrayList<>(roleEntity.getPrivilegeEntities());

        allPrivilegeEntities.sort(Comparator.comparing(BaseEntity::getId));
        currentPrivileges.sort(Comparator.comparing(BaseEntity::getId));

        ListIterator<PrivilegeEntity> iterator = currentPrivileges.listIterator();

        for (PrivilegeEntity privilege : allPrivilegeEntities) {
            ids.add(privilege.getId());
            if (iterator.hasNext()) {
                if (privilege.getId().equals(iterator.next().getId())) {
                    hasPermissions.add(true);
                } else {
                    hasPermissions.add(false);
                    iterator.previous();
                }
            } else {
                hasPermissions.add(false);
            }
        }
    }



    public List<Long> getCurrentPrivilegeIds() throws PrivilegesOutdatedException {
        List<Long> ids = new ArrayList<>();
        if (this.ids.size() != hasPermissions.size()) throw new PrivilegesOutdatedException("Used privileges are outdated");
        for(int i = 0; i < hasPermissions.size(); i++) {
            if(hasPermissions.get(i)) {
                ids.add(this.ids.get(i));
            }
        }
        return ids;
    }
}
