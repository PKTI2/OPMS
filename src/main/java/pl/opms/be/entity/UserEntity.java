package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class UserEntity {

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "personaldataid")
    private Long personalDataId;

//    private PersonalDataEntity personalDataEntity;


    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}

    public void setPersonalDataId(Long personalDataId) {this.personalDataId = personalDataId;}
    public Long getPersonalDataId() {return personalDataId;}

    public void setUserName(String userName) {this.userName = userName;}
    public String getUserName() {return userName;}

//    public void setPersonalDataEntity(PersonalDataEntity personalDataEntity) {this.personalDataEntity = personalDataEntity;}
//    public PersonalDataEntity getPersonalDataEntity() {return personalDataEntity;}
}
