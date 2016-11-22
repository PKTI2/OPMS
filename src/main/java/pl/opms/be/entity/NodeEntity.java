package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.opms.fe.test.NodeType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NODE_DEFINITION")
public class NodeEntity extends BaseEntity {
    @Column(name = "label")
    private String label;

    @Column(name = "node_type")
    private NodeType nodeType;
}
