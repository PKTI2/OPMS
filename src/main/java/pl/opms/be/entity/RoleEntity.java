package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Dawid on 29.11.2016 at 19:45.
 */

@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "ROLE")
public class RoleEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany
    private Set<PrivilegeEntity> privilegeEntities;
}
