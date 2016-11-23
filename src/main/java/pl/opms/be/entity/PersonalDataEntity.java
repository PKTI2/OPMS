package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAL_DATA_TABLE")
public class PersonalDataEntity extends BaseEntity {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastname")
    private String lastname;


//    @Column(name = "addressid")
//    private Long addressId; //czy potrzebne
    private AddressEntity address;
    @ManyToOne
    @JoinColumn (name = "AddressEntity.id")
    public AddressEntity getAddress(){return address;}

    public void setAddress(AddressEntity address) {this.address = address;}

    //    @Column(name = "mailaddressid")
//    private Long mailAddressId; //czy potrzebne
    private AddressEntity mailAddress;
    @ManyToOne
    @JoinColumn (name = "mailAddressEntity.id")
    public AddressEntity getMailAddress(){return mailAddress;}

    public void setMailAddress(AddressEntity mailAddress) {this.mailAddress = mailAddress;}

    // nowa tabela idrekordu/idusera/telefon
    private List<PhoneNumberEntity> phoneNumberList = new ArrayList<PhoneNumberEntity>();
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="NumberEntity.personalDataId")
    public List<PhoneNumberEntity> getPhoneNumberList(){return phoneNumberList;}
//    person.getPhoneNumberList().add(phoneEntity); //phoneEntity(this.getId(),"123-456-789");


    @Column(name = "peselnumber")
    private String peselNumber;

    @Column(name = "birthdate")
    private Date birthDate;

    UserEntity userEntity;
    @OneToOne(mappedBy = "userEntity")
    public UserEntity getUserEntity(){return userEntity;}

    public void setUserEntity(UserEntity userEntity) {this.userEntity = userEntity;}

    public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}
    public Date getBirthDate() {return birthDate;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getFirstName() {return firstName;}

    public void setLastname(String lastname) {this.lastname = lastname;}
    public String getLastname() {return lastname;}

    public void setPeselNumber(String peselNumber) {this.peselNumber = peselNumber;}
    public String getPeselNumber() {return peselNumber;}

}
