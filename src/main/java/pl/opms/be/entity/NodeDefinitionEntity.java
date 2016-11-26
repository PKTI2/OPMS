package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.opms.fe.test.NodeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NODE_DEFINITION")
public class NodeDefinitionEntity extends BaseEntity {
    @Column(name = "label")
    private String label;

    @Column(name = "type")
    @Enumerated
    private NodeType nodeType;
}
