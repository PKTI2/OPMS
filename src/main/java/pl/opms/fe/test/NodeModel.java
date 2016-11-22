package pl.opms.fe.test;

import lombok.Data;
import org.primefaces.model.UploadedFile;

import java.io.Serializable;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@Data
public class NodeModel implements Serializable {
    private String stringValue;
    private Integer intValue;
    private Double doubleValue;
    private UploadedFile fileValue;
    private Boolean booleanValue;
}
