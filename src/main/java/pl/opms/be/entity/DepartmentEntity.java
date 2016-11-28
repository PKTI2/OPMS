package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT_TABLE")
public class DepartmentEntity extends BaseEntity {

    private List<RoomEntity> roomList = new ArrayList<RoomEntity>();

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="RoomEntity.departmentId")
    public List<RoomEntity> getRoomList(){return roomList;}
//    department.getRoomList().add(roomEntity);
//    department.getRoomList().remove(roomEntity);


    @Column(name = "departmentname")
    private String departmentName;

    public void setDepartmentName(String departmentName) {this.departmentName = departmentName;}
    public String getDepartmentName() {return departmentName;}

}
