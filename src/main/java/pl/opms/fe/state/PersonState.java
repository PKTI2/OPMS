package pl.opms.fe.state;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import pl.opms.be.entity.PersonEntity;

import java.util.List;

/**
 * Created by Piotr Borczyk on 15.11.2016.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Scope("flow")
public class PersonState extends AbstractState {

    private List<PersonEntity> currentPersons;
    private PersonEntity current = new PersonEntity();
}
