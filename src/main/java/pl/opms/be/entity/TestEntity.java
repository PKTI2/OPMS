package pl.opms.be.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@Data
@Entity
@Table(name = "TEST")
public class TestEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "node_entities")
    @OneToMany
    @JoinColumn
    private List<NodeEntity> nodeEntities;

    private NodeInstance nodeInstance;
}
