package pl.opms.fe.state;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.opms.be.entity.TestInstanceEntity;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class TestState extends AbstractState {
    TestInstanceEntity testInstanceEntity = new TestInstanceEntity();
}
