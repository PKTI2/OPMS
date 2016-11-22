package pl.opms.fe.controller;

import pl.opms.fe.state.TestState;
import pl.opms.fe.test.Node;
import pl.opms.fe.test.NodeModel;
import pl.opms.fe.test.NodeType;
import pl.opms.fe.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */
public class TestController extends AbstractController<TestState> {
    @Override
    public void init(TestState state) {
        Test test = new Test();
        test.setName("Ciśnienie");
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("Imię", NodeType.STRING,new NodeModel()));
        nodes.add(new Node("CheckBoksik",NodeType.BOOL_CHECK_BOX,new NodeModel()));
        nodes.add(new Node("Int",NodeType.INT,new NodeModel()));
        nodes.add(new Node("Double",NodeType.DOUBLE,new NodeModel()));
        nodes.add(new Node("Plik",NodeType.FILE,new NodeModel()));
        nodes.add(new Node("Dzik",NodeType.BOOL_CHECK_BOX,new NodeModel()));
        test.setNodes(nodes);
        state.setTest(test);
    }
}
