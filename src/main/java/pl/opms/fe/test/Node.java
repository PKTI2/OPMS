package pl.opms.fe.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@Data
@AllArgsConstructor
public class Node implements Serializable {
    private String label;
    private NodeType nodeType;
    private NodeModel model;
}
