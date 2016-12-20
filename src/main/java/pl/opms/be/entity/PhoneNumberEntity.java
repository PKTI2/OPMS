package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PHONE_NUMBER_TABLE")
public class PhoneNumberEntity extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    public PhoneNumberEntity(Long id) {
        this.id = id;
    }
}
