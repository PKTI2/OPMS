package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Val on 2016-11-24.
 */

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "PATIENT_ENTITY")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class PatientEntity extends UserEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private PatientDataEntity patientData;

//    @Column (name = "patient_history")
//    private PatientHistoryEntity patientHistory

    @Column (name = "additional_phone_number")
    private String additionalPhoneNumber;
}
