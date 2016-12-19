package pl.opms.be.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Adam on 2016-12-04.
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class AddingPatientDefinitionEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "deprecated")
    private boolean deprecated;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NodeDefinitionEntity> nodeEntities;
}
