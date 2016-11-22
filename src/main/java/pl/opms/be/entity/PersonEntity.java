package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Piotr Borczyk on 15.11.2016.
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON_TABLE")
public class PersonEntity extends BaseEntity {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
}
