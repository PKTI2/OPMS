package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class PrivilegeEntity extends BaseEntity {
    @Column(name = "name_role")
    private String nameRole;

    @Column(name = "name")
    private String name;

    public PrivilegeEntity(String name) {
        this.name = name;
        this.nameRole = "ROLE_" + name.toUpperCase();
    }
}
