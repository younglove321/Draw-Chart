package com.e.hw6_chartgraphdraw;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity  extends AppCompatActivity {
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        pieChart = findViewById(R.id.piechart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(7.8f, "82년생 김지영"));
        entries.add(new PieEntry(7.84f, "조커"));
        entries.add(new PieEntry(7.49f, "말레피센트2"));
        entries.add(new PieEntry(7.25f, "가장보통의연애"));
        entries.add(new PieEntry(6.39f, "퍼펙트맨"));


        PieDataSet set = new PieDataSet(entries, "상영작 SNS 종합 평점");
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.invalidate();

        set.setValueTextSize(20f);
        set.setColors(ColorTemplate.JOYFUL_COLORS);
     }

    }


