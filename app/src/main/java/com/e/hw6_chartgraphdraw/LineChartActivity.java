package com.e.hw6_chartgraphdraw;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class LineChartActivity extends AppCompatActivity {
    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        setTitle("꺾은선 그래프");

        lineChart = (LineChart) findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 4268));
        entries.add(new Entry(1f, 3478));
        entries.add(new Entry(2f, 2149));
        entries.add(new Entry(3f, 11417));
        entries.add(new Entry(4f, 15315));
        entries.add(new Entry(5f, 32602));
        entries.add(new Entry(6f, 48745));


        LineDataSet dataset = new LineDataSet(entries, "영화 '82년생 김지영' 게시물수 추이");
        dataset.setCircleRadius(6);
        dataset.setCircleColor(Color.parseColor("#FFA1B4DC"));
        dataset.setCircleColorHole(Color.BLUE);
        dataset.setColor(Color.parseColor("#FFA1B4DC"));
        dataset.setDrawCircleHole(true);
        dataset.setDrawCircles(true);
        dataset.setDrawHorizontalHighlightIndicator(false);
        dataset.setDrawHighlightIndicators(false);


        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("2019-10-18");
        labels.add("2019-10-19");
        labels.add("2019-10-20");
        labels.add("2019-10-21");
        labels.add("2019-10-22");
        labels.add("2019-10-23");
        labels.add("2019-10-24");

        XAxis x = lineChart.getXAxis();
        //x.setTextColor(Color.WHITE);
        x.setLabelCount(7);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if(labels.size()>(int)value)
                    return labels.get((int) value);
                else
                    return null;
            }
        });
        x.setTextSize(15f);

        dataset.setValueTextSize(15f);
        LineData data = new LineData(dataset);
     //   dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
       // dataset.setDrawCubic(true); //선 둥글게 만들기
        dataset.setDrawFilled(true); //그래프 밑부분 색칠

        lineChart.setData(data);
        lineChart.animateY(5000);



    }
}
