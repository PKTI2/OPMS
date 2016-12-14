package pl.opms.utils.role;

import lombok.Data;
import lombok.ToString;
import pl.opms.be.entity.PrivilegeEntity;
import pl.opms.be.entity.RoleEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dawid on 11.12.2016 at 21:56.
 */
@Data
@ToString
public class Wrapper {
    private List<RoleUtil> roles;

    public Wrapper(List<RoleEntity> roleEntities, List<PrivilegeEntity> allPrivilegeEntities) {
        roles = roleEntities.stream().map(roleEntity -> new RoleUtil(roleEntity, allPrivilegeEntities))
                .collect(Collectors.toList());
    }
}
