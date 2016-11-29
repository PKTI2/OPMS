package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "USER_TABLE")
@Inheritance( strategy = InheritanceType.JOINED )
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "personal_data_id")
    private Long personalDataId;

    @OneToOne (cascade = {CascadeType.ALL})
    //@JoinColumn(name="PersonalDataEntity.id")
    private PersonalDataEntity personalDataEntity;


}
