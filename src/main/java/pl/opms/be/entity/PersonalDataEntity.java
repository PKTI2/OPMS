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

}
