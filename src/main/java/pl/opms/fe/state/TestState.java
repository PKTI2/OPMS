package pl.opms.fe.state;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.opms.be.entity.TestEntity;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class TestState extends AbstractState {
    TestEntity testEntity = new TestEntity();
}
