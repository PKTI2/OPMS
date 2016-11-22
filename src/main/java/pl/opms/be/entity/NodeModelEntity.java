package pl.opms.be.entity;

import lombok.Data;
import org.primefaces.model.UploadedFile;
import pl.opms.be.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@Data
@Entity
@Table(name = "NODE_MODEL")
public class NodeModelEntity extends BaseEntity {
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
}
