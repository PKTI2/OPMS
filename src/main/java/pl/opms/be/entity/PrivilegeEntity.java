package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Dawid on 29.11.2016 at 19:47.
 */

@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "PRIVILEGE_ENTITY")
public class PrivilegeEntity extends BaseEntity implements GrantedAuthority {
    @Column(name = "name_role")
    private String nameRole;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    public void setName(String name) {
        this.name = name;
        this.nameRole = "ROLE_" + name.toUpperCase().replace(' ', '_');
    }

    @Override
    public String getAuthority() {
        return nameRole;
    }
}