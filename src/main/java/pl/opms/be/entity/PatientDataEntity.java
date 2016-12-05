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

    @Column (name = "blood_type")
    @Enumerated
    private BloodType bloodType;

    @Column (name = "blood_antigen")
    private boolean bloodAntigen;

    @Column (name = "weight")
    private Float weight;

    @Column (name = "gender")
    @Enumerated
    private Gender gender;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "room_id")
    private RoomEntity room;
}
