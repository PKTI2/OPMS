package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT_TABLE")
public class DepartmentEntity extends BaseEntity {
    @OneToMany
    private List<RoomEntity> rooms;

    @Column(name = "department_name")
    private String departmentName;
}
