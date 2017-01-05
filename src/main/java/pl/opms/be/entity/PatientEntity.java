package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

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

    @OneToOne (cascade = {CascadeType.ALL})
    private PersonalDataEntity personalDataEntity;

    @OneToMany
    private List<TestInstanceEntity> tests;
}
