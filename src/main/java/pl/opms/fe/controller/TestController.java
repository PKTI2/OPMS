package pl.opms.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.opms.be.repository.TestRepository;
import pl.opms.fe.state.TestState;
import pl.opms.be.entity.NodeEntity;
import pl.opms.be.entity.NodeModelEntity;
import pl.opms.fe.test.NodeType;
import pl.opms.be.entity.TestEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */
public class TestController extends AbstractController<TestState> {
    @Autowired
    private transient TestRepository testRepository;

    @Override
    public void init(TestState state) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("Ciśnienie");
        List<NodeEntity> nodeEntities = new ArrayList<>();
        nodeEntities.add(new NodeEntity("Imię", NodeType.STRING,new NodeModelEntity()));
        nodeEntities.add(new NodeEntity("CheckBoksik",NodeType.BOOL_CHECK_BOX,new NodeModelEntity()));
        nodeEntities.add(new NodeEntity("Int",NodeType.INT,new NodeModelEntity()));
        nodeEntities.add(new NodeEntity("Double",NodeType.DOUBLE,new NodeModelEntity()));
        nodeEntities.add(new NodeEntity("Plik",NodeType.FILE,new NodeModelEntity()));
        nodeEntities.add(new NodeEntity("Dzik",NodeType.BOOL_CHECK_BOX,new NodeModelEntity()));
        testEntity.setNodeEntities(nodeEntities);
        state.setTestEntity(testEntity);
        testRepository.save(testEntity);
    }
}
