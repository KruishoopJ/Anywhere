package nl.johnbaaij.anywhere.main.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.lifecycle.ViewModelProviders;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractFragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.HeatDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.HeatMap;
import com.anychart.charts.Pie;

import com.anychart.graphics.vector.SolidFill;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends AbstractFragment {

    private DashboardViewModel dashboardViewModel;
    Cartesian cartesian;
    AnyChartView anyChartView;
    Pie pie;
    HeatMap riskMap;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        super.onCreate(savedInstanceState);
        setToolbarTitle(getString(R.string.title_dashboard));
        chart(root);

        return root;
    }



    private void chart(View root){
        anyChartView = root.findViewById(R.id.any_chart_view);

        //pie = AnyChart.pie();


        riskMap = AnyChart.heatMap();

        riskMap.stroke("1 #fff");
        riskMap.hovered()
                .stroke("6 #fff")
                .fill(new SolidFill("#545f69", 1d))
                .labels("{ fontColor: '#fff' }");

        //riskMap.interactivity().selectionMode(SelectionMode.NONE);

        riskMap.title().enabled(true);
        riskMap.title()
                .text("Heatmap")
                .padding(0d, 0d, 20d, 0d);

        riskMap.labels().enabled(false);
        riskMap.labels()
                .minFontSize(14d);

        riskMap.yAxis(0).stroke(null);
        riskMap.yAxis(0).labels().padding(0d, 15d, 0d, 0d);
        riskMap.yAxis(0).ticks(false);
        riskMap.xAxis(0).stroke(null);
        riskMap.xAxis(0).ticks(false);



        List<DataEntry> data = new ArrayList<>();
        data.add(new CustomHeatDataEntry("1", "1", 2, "#0432FF"));
        data.add(new CustomHeatDataEntry("1", "2", 2, "#50A7F9"));
        data.add(new CustomHeatDataEntry("1", "3", 2, "#009193"));
        data.add(new CustomHeatDataEntry("1", "4", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("1", "5", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("2", "1", 2, "#50A7F9"));
        data.add(new CustomHeatDataEntry("2", "2", 2, "#009193"));
        data.add(new CustomHeatDataEntry("2", "3", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("2", "4", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("2", "5", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("3", "1", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("3", "2", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("3", "3", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("3", "4", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("3", "5", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("4", "1", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("4", "2", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("4", "3", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("4", "4", 2, "#ef6c00"));
        data.add(new CustomHeatDataEntry("4", "5", 2, "#ef6c00"));
        data.add(new CustomHeatDataEntry("5", "1", 2, "#ffb74d"));
        data.add(new CustomHeatDataEntry("5", "2", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("5", "3", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("5", "4", 2, "#ef6c00"));
        data.add(new CustomHeatDataEntry("5", "5", 3, "#d84315"));

        riskMap.data(data);


        anyChartView.setChart(riskMap);
    }


    private class CustomHeatDataEntry extends HeatDataEntry {
        CustomHeatDataEntry(String x, String y, Integer heat, String fill) {
            super(x, y, heat);
            setValue("fill", fill);
        }
    }



}