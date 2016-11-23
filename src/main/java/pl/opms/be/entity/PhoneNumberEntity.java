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
@Table(name = "PHONE_NUMBER_TABLE")
public class PhoneNumberEntity extends BaseEntity {

    @Column(name = "personaldataid")
    private Long personalDataId;

    @Column(name = "phonenumber")
    private String phoneNumber;

    public Long getPersonalDataId() {return personalDataId;}
    public void setPersonalDataId(Long personalDataId) {this.personalDataId = personalDataId;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

}
