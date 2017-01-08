package pl.opms.be.utils.chart;

import lombok.Data;
import pl.opms.be.entity.NodeInstanceEntity;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.TestInstanceEntity;
import pl.opms.consts.NodeType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Dawid on 07.01.2017 at 19:41.
 */
@Data
public class ChartDataPicker {
    private List<TestInstanceEntity> testInstanceEntities;
    private Long testDefinitionId;
    private List<ChartData> chartData;
    private DateFormat dateFormat;

    public ChartDataPicker(PatientEntity patientEntity, Long testDefinitionId) {
        this.testDefinitionId = testDefinitionId;
        this.testInstanceEntities = getTestInstance(patientEntity);
        this.chartData = new ArrayList<>();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    }

    private List<TestInstanceEntity> getTestInstance(PatientEntity patientEntity) {
        return patientEntity.getTests().stream().filter(testInstanceEntity ->
                testInstanceEntity.getTestDefinitionEntity().getId().equals(testDefinitionId)).
                collect(Collectors.toList());
    }

    private void loadChartData() {
        int listNodeSize = testInstanceEntities.get(0).getNodes().size();
        int listTestSize = testInstanceEntities.size();

        for (int i = 0; i < listNodeSize; i++) {
            Map<String, Double> chartData = new HashMap<>();
            for (int k = 0; k < listTestSize; k++) {
                NodeInstanceEntity nodeInstanceEntity = testInstanceEntities.get(k).getNodes().get(i);
                NodeType nodeType = nodeInstanceEntity.getNodeDefinition().getNodeType();
                if (nodeType.equals(NodeType.STRING) || nodeType.equals(NodeType.BOOL_CHECK_BOX)) {
                    break;
                }

                if (nodeType.equals(NodeType.INT)) {
                    chartData.put(dateFormat.format(testInstanceEntities.get(k).getCreationDate()),
                            new Double(nodeInstanceEntity.getIntValue()));
                } else if (nodeType.equals(NodeType.DOUBLE)) {
                    chartData.put(dateFormat.format(testInstanceEntities.get(k).getCreationDate()),
                            nodeInstanceEntity.getDoubleValue());
                }
            }

            if (chartData.size() > 0) {
                this.chartData.add(new ChartData(testInstanceEntities.get(0).getNodes().get(i).getNodeDefinition().getLabel(), chartData));
            }
        }
    }

    public List<ChartData> getChartData() {
        loadChartData();
        return chartData;
    }
}
