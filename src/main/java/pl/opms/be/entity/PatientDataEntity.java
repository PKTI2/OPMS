package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.opms.consts.BloodType;
import pl.opms.consts.Gender;

import javax.persistence.*;

/**
 * Created by Val on 2016-11-24.
 */

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PATIENT_DATA")
public class PatientDataEntity extends BaseEntity {

    @Column (name = "height")
    private Integer height;

    @Column (name = "blood_antigen")
    private boolean bloodAntigen;

    @Column (name = "weight")
    private Float weight;

    @ManyToOne (cascade = CascadeType.ALL)
    private DepartmentEntity department;

    @ManyToOne (cascade = CascadeType.ALL)
    private RoomEntity room;

    @Column (name = "blood_type")
    @Enumerated
    private BloodType bloodType;

    @Column (name = "gender")
    @Enumerated
    private Gender gender;
}
