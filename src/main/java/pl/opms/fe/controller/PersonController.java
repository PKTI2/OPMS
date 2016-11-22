package pl.opms.fe.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import pl.opms.be.entity.PersonEntity;
import pl.opms.be.repository.PersonPageRepository;
import pl.opms.be.repository.PersonRepository;
import pl.opms.fe.state.PersonState;

import javax.transaction.TransactionManager;
import java.util.List;

/**
 * Created by Piotr Borczyk on 15.11.2016.
 */

@Controller
@Scope("flow")
public class PersonController extends AbstractController<PersonState> {


    @Autowired
    private transient PersonRepository personRepository;


    @Autowired
    private transient PersonPageRepository personPageRepository;


    private Page<PersonEntity> page;

    @Override
    public void init(PersonState state) {
        page = personPageRepository.findAll(new PageRequest(1,20));
        state.setCurrentPersons((List<PersonEntity>) personRepository.findAll());
    }

    public void save(PersonState state) {
        personRepository.save(state.getCurrent());
    }

}
