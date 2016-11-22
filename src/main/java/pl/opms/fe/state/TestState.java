package pl.opms.fe.state;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.primefaces.model.UploadedFile;
import pl.opms.fe.test.Node;
import pl.opms.fe.test.Test;

import java.util.List;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class TestState extends AbstractState {
    Test test = new Test();
}
