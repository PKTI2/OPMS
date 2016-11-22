package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT_TABLE")
public class DepartmentEntity {

//    private List<RoomEntity> roomsList;

    @Column(name = "departmentname")
    private String departmentName;

}
