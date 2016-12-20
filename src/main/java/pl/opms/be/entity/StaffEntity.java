package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Dawid on 17.12.2016 at 15:03.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "staff")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class StaffEntity extends UserEntity {
    @Column(name = "title")
    private String medicalTitle;

    public StaffEntity(String password) {
        this.setPassword(password);
    }
}
