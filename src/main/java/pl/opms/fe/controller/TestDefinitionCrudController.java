package pl.opms.fe.controller;


import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import pl.opms.be.entity.NodeDefinitionEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.repository.TestDefinitionRepository;
import pl.opms.consts.MessageType;
import pl.opms.fe.test.NodeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Piotr Borczyk on 29.11.2016.
 */

@Controller
@Scope("flow")
public class TestDefinitionCrudController extends AbstractController {

    @Autowired
    private transient TestDefinitionRepository testDefinitionRepository;


    @Getter
    @Setter
    private TestDefinitionEntity selected;

    @Getter
    @Setter
    private List<TestDefinitionEntity> testDefinitions;

    @Getter
    @Setter
    private NodeType[] nodeTypes = NodeType.values();

    @Getter
    @Setter
    private TestDefinitionEntity current = new TestDefinitionEntity("", false, new ArrayList<>());

    @Override
    public void init() {

    }

    public void clear() {
        current = new TestDefinitionEntity("", false, new ArrayList<>());
    }

    public void save() {
        try {
            testDefinitionRepository.save(current);
            sendMessage("Zapisano");
        } catch (DataAccessException e) {
            sendMessage("Zapisywanie nie powiodło się", MessageType.ERROR);
            throw e;
        }
    }

    public void deprecate() {
        selected.setDeprecated(true);
        try {
            testDefinitionRepository.save(selected);
            sendMessage("Wykonano");
        }catch (DataAccessException e) {
            sendMessage("Nie udało się!",MessageType.ERROR);
            throw e;
        }
    }

    public void onNodeDrop(DragDropEvent ddEvent) {
        NodeType nodeType = ((NodeType) ddEvent.getData());

        current.getNodeEntities().add(new NodeDefinitionEntity("bez nazwy",nodeType));
    }

    public void onAddDialogClose() {
        current = new TestDefinitionEntity("", false, new ArrayList<>());
    }

}
