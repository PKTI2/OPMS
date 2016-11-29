package pl.opms.be.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid on 22.11.2016 at 19:32.
 */

@ToString
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor

@Table(name = "TEST_INSTANCE")
public class TestInstanceEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NodeInstanceEntity> nodes;

    public TestInstanceEntity(TestDefinitionEntity testDefinition) {
        this.name = testDefinition.getName();
        this.nodes = new ArrayList<>();

        testDefinition.getNodeEntities().forEach(e -> nodes.add(new NodeInstanceEntity(e)));
    }
}
