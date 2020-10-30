package com.e.hw6_chartgraphdraw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {
    private  BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        setTitle("막대 그래프");

        barChart = (BarChart) findViewById(R.id.barchart);

        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setTextColor(Color.WHITE);
        l.setYOffset(30f);
        l.setXOffset(15f);
        l.setTextSize(15f);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 9.03f));
        entries.add(new BarEntry(1f, 9.29f));
        entries.add(new BarEntry(2f, 8.65f));
        entries.add(new BarEntry(3f, 8.58f));
        entries.add(new BarEntry(4f, 8.25f));
        entries.add(new BarEntry(5f, 9.00f));
        entries.add(new BarEntry(6f, 8.59f));

        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(0f, 8.13f));
        entries2.add(new BarEntry(1f, 6.66f));
        entries2.add(new BarEntry(2f, 8.57f));
        entries2.add(new BarEntry(3f, 7.79f));
        entries2.add(new BarEntry(4f, 7.82f));
        entries2.add(new BarEntry(5f, 8.66f));
        entries2.add(new BarEntry(6f, 7.61f));

        ArrayList<BarEntry> entries3 = new ArrayList<>();
        entries3.add(new BarEntry(0f, 5.00f));
        entries3.add(new BarEntry(1f, 6.79f));
        entries3.add(new BarEntry(2f, 6.43f));
        entries3.add(new BarEntry(3f, 6.33f));
        entries3.add(new BarEntry(4f, 6.57f));
        entries3.add(new BarEntry(5f, 7.64f));
        entries3.add(new BarEntry(6f, 5.67f));

        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("신의한수");
        labels.add("82년생김지영");
        labels.add("터미네이터");
        labels.add("아담스패밀리");
        labels.add("날씨의아이");
        labels.add("조커");
        labels.add("말레피센트2");

        XAxis x = barChart.getXAxis();
        x.setTextColor(Color.WHITE);
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

        barChart.getAxisRight().setEnabled(false);
        BarDataSet set1 = new BarDataSet(entries, "관람객평점");
        BarDataSet set2 = new BarDataSet(entries2, "네티즌평점");
        BarDataSet set3 = new BarDataSet(entries3, "기자·평론가평점");

        set1.setColors(Color.parseColor("#E8D9FF"));
        set2.setColors(Color.parseColor("#A566FF"));
        set3.setColors(Color.parseColor("#3F0099"));

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        dataSets.add(set3);

        BarData data = new BarData(set1, set2, set3);
        data.setBarWidth(0.4f);
        barChart.setData(data);
        barChart.animateY(5000);
        barChart.invalidate();
    }

}
