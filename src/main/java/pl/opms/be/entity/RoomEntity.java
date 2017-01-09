package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROOM_TABLE")
public class RoomEntity extends BaseEntity {

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "free_bed")
    private Integer freeBed;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private DepartmentEntity department;
}
