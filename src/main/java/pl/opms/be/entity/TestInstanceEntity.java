package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dawid on 22.11.2016 at 19:32.
 */

@ToString
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "TEST_INSTANCE")
public class TestInstanceEntity extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private List<NodeInstanceEntity> nodes;

    @OneToOne(cascade = CascadeType.MERGE)
    private TestDefinitionEntity testDefinitionEntity;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public TestInstanceEntity(TestDefinitionEntity testDefinition) {
        this.nodes = new ArrayList<>();
        this.testDefinitionEntity = testDefinition;

        testDefinition.getNodeEntities().forEach(e -> nodes.add(new NodeInstanceEntity(e)));
    }
}
