package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.primefaces.model.UploadedFile;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Dawid on 22.11.2016 at 19:28.
 */

@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "NODE_INSTANCE")
public class NodeInstanceEntity extends BaseEntity{
    @OneToOne(cascade = CascadeType.MERGE)
    private NodeDefinitionEntity nodeDefinition;

    @Column(name = "string_value")
    private String stringValue;

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "double_value")
    private Double doubleValue;

    @Column(name = "file_value")
    @Lob
    private UploadedFile fileValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    public NodeInstanceEntity(NodeDefinitionEntity nodeDefinition) {
        this.nodeDefinition = nodeDefinition;
    }
}
