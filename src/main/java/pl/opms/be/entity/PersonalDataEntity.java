package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAL_DATA_TABLE")
public class PersonalDataEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private AddressEntity address;

    @Column(name = "mail_address")
    private AddressEntity mailAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumberList;

    @Column(name = "pesel_number")
    private String peselNumber;

    @Column(name = "birth_date")
    private Date birthDate;
}
