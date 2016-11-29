package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "TEST_DEFINITION")
public class TestDefinitionEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "deprecated")
    private boolean deprecated;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NodeDefinitionEntity> nodeEntities;
}
