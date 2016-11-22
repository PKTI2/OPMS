package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAL_DATA_TABLE")
public class PersonalDataEntity {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "addressid")
    private Long addressId; // a moze obiekt klasy AddressEntity?

//    private AddressEntity address;

    @Column(name = "mailaddressid")
    private Long mailAddressId;

//    private AddressEntity mailAddress;

    @Column(name = "phoneNumbersid")
    private Long phoneUserId; // tabela idrekordu/idusera/telefon

//    private List<String> phoneNumbersList;

    @Column(name = "peselnumber")
    private String peselNumber;

    @Column(name = "birthdate")
    private Date birthDate;

    public void setAddressId(Long addressId) {this.addressId = addressId;}
    public Long getAddressId() {return addressId;}

    public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}
    public Date getBirthDate() {return birthDate;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getFirstName() {return firstName;}

    public void setLastname(String lastname) {this.lastname = lastname;}
    public String getLastname() {return lastname;}

    public void setMailAddressId(Long mailAddressId) {this.mailAddressId = mailAddressId;}
    public Long getMailAddressId() {return mailAddressId;}

    public void setPeselNumber(String peselNumber) {this.peselNumber = peselNumber;}
    public String getPeselNumber() {return peselNumber;}

    public void setPhoneUserId(Long phoneUserId) {this.phoneUserId = phoneUserId;}
    public Long getPhoneUserId() {return phoneUserId;}

//    public void setAddress(AddressEntity address) {this.address = address;}
//    public AddressEntity getAddress() {return address;}
//
//    public void setMailAddress(AddressEntity mailAddress) {this.mailAddress = mailAddress;}
//    public AddressEntity getMailAddress() {return mailAddress;}
//
//    public void setPhoneNumbersList(List<String> phoneNumbersList) {this.phoneNumbersList = phoneNumbersList;}
//    public List<String> getPhoneNumbersList() {return phoneNumbersList;}
//
//    public void addPhoneToNumberList(){
////        ???
//    }
//    public Long getPhoneNumber(){
////        ???
//        return new Long(0);
//    }
//    public void removePhoneNumber(Long number){
////        ???
//    }
}
