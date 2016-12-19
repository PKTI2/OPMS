package pl.opms.be.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2016-12-04.
 */

@ToString
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor

public class AddingPatientInstanceEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NodeInstanceEntity> nodes;

    public AddingPatientInstanceEntity(AddingPatientDefinitionEntity addingPatientDefinition) {
        this.name = addingPatientDefinition.getName();
        this.nodes = new ArrayList<>();

        addingPatientDefinition.getNodeEntities().forEach(e -> nodes.add(new NodeInstanceEntity(e)));
    }

}
