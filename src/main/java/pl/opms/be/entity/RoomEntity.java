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
public class RoomEntity extends BaseEntity {

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "freebed")
    private Integer freeBed;

    @Column(name = "roomnumber")
    private Integer roomNumber;

    @Column(name = "departmentid")
    private Long departmentId; //nowe pole

    public void setCapacity(Integer capacity) {this.capacity = capacity;}
    public Integer getCapacity() {return capacity;}

    public void setFreeBed(Integer freeBed) {this.freeBed = freeBed;}
    public Integer getFreeBed() {return freeBed;}

    public void setRoomNumber(Integer roomNumber) {this.roomNumber = roomNumber;}
    public Integer getRoomNumber() {return roomNumber;}

    public void setDepartmentId(Long departmentId) {this.departmentId = departmentId;}
    public Long getDepartmentId() {return departmentId;}
}
