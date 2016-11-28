package pl.opms.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.opms.be.entity.NodeDefinitionEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.entity.TestInstanceEntity;
import pl.opms.be.repository.TestDefinitionRepository;
import pl.opms.be.repository.TestInstanceRepository;
import pl.opms.fe.state.TestState;
import pl.opms.fe.test.NodeType;

import java.util.Arrays;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */
public class TestController extends AbstractController<TestState> {
    @Autowired
    private transient TestDefinitionRepository testDefinitionRepository;

    @Autowired
    private transient TestInstanceRepository testInstanceRepository;

    @Override
    public void init(TestState state) {
        TestDefinitionEntity testDefinitionEntity = new TestDefinitionEntity(
                "test", false,
                Arrays.asList(
                        new NodeDefinitionEntity("Ten", NodeType.STRING),
                        new NodeDefinitionEntity("Widok", NodeType.BOOL_CHECK_BOX),
                        new NodeDefinitionEntity("Jest", NodeType.INT),
                        new NodeDefinitionEntity("Generowany", NodeType.DOUBLE),
                        new NodeDefinitionEntity("Dynamicznie", NodeType.FILE),
                        new NodeDefinitionEntity("Na podstawie ", NodeType.BOOL_CHECK_BOX),
                        new NodeDefinitionEntity("Kodu Java i bazy danych ", NodeType.BOOL_CHECK_BOX)
                )
        );
        testDefinitionRepository.save(testDefinitionEntity);
        testDefinitionRepository.findAll().forEach(System.out::println);

        TestInstanceEntity testInstanceEntity = new TestInstanceEntity(testDefinitionRepository.findOne(1L));
        state.setTestInstanceEntity(testInstanceEntity);
    }

    public void save(TestState testState) {
        testInstanceRepository.save(testState.getTestInstanceEntity());
    }
}
