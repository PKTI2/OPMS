package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Collection;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
@Inheritance( strategy = InheritanceType.JOINED )
public class UserEntity extends BaseEntity {
    @Column(name = "password_expired")
    private Boolean passwordExpired = true;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled = true;

    @OneToOne(cascade = CascadeType.MERGE)
    private RoleEntity roleEntity;

    @OneToOne(cascade = {CascadeType.ALL})
    private PersonalDataEntity personalDataEntity = new PersonalDataEntity();
}
