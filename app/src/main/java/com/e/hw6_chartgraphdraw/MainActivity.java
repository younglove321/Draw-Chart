package com.e.hw6_chartgraphdraw;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //파이 그래프

        ImageView button_pie =  ( ImageView)findViewById(R.id.button_pie);

        button_pie.setOnClickListener(this);


        //라인 그래프

        ImageView button_line =  ( ImageView)findViewById(R.id.button_line);

        button_line.setOnClickListener(this);


        //막대 그래프

        ImageView button_bar =  ( ImageView)findViewById(R.id.button_bar);
        button_bar.setOnClickListener(this);

    }


    @Override

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_pie:


                startActivity(new Intent(this, PieChartActivity.class));
                break;


            case R.id.button_line:

                startActivity(new Intent(this, LineChartActivity.class));
                break;


            case R.id.button_bar:

                startActivity(new Intent(this, BarChartActivity.class));
                break;

        }

    }


}

