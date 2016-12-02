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
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "PRIVILEGE_ENTITY")
public class PrivilegeEntity extends BaseEntity implements GrantedAuthority{
    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
