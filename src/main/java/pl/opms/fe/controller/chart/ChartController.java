package pl.opms.fe.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.utils.chart.ChartData;
import pl.opms.be.utils.chart.ChartDataPicker;

import java.util.List;

/**
 * Created by Dawid on 06.01.2017 at 16:09.
 */
@Controller
@RequestMapping("/chart")
public class ChartController {
    @RequestMapping("")
    public String showChart(@RequestParam(value = "patient") PatientEntity patientEntity,
                            @RequestParam(value = "testDefId") Long testDefId, ModelMap modelMap) {
        ChartDataPicker chartDataPicker = new ChartDataPicker(patientEntity, testDefId);
        List<ChartData> chartDataList = chartDataPicker.getChartData();
        modelMap.addAttribute("list", chartDataList);
        return "chart/chart";
    }
}
