package pl.opms.fe.test;

import javafx.scene.control.Label;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@Data
public class Test implements Serializable {
    private String name;
    private List<Node> nodes;
}
