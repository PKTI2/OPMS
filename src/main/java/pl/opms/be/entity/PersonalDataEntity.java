package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.ArrayList;
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

    @OneToOne(cascade = {CascadeType.ALL})
    private AddressEntity address;

    @Column(name = "is_mail_address")
    private Boolean isMailAddress = false;

    @OneToOne(cascade = {CascadeType.ALL})
    private AddressEntity mailAddress;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumbers = new ArrayList<>();

    @Column(name = "pesel_number")
    private String peselNumber;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
