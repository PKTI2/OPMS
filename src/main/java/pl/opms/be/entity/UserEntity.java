package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "personaldataid")
    private Long personalDataId;

    private PersonalDataEntity personalDataEntity;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PersonalDataEntity.id")
    public PersonalDataEntity getPersonalDataEntity() {
        return personalDataEntity;
    }

    public void setPersonalDataEntity(PersonalDataEntity personalDataEntity) {
        this.personalDataEntity = personalDataEntity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPersonalDataId(Long personalDataId) {
        this.personalDataId = personalDataId;
    }

    public Long getPersonalDataId() {
        return personalDataId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

}
