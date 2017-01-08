package pl.opms.be.utils.chart;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * Created by Dawid on 07.01.2017 at 19:41.
 */

@Data
public class ChartData {
    private String chartName;
    private String jsonChartDataMap;

    public ChartData(String chartName, Map<String, Double> chartData) {
        this.chartName = chartName;
        Gson gson = new Gson();
        this.jsonChartDataMap = gson.toJson(chartData);
    }
}
