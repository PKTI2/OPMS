package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROOM_TABLE")
public class RoomEntity {

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "freebed")
    private Integer freeBed;

    @Column(name = "roomnumber")
    private Integer roomNumber;

//    @Column(name = "departmentid")
//    private Long departmentId; //nowe pole

}
