package com.pawan.buspricecomparison;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SearchBuses extends AppCompatActivity implements View.OnClickListener {

    private TextView source, destination, date;
    private ImageView swap;
    private Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_buses);
        initializeView();




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            String SourceCity = data.getStringExtra("SourceCity");
            source.setText(SourceCity);
        }else if(resultCode == 2){
            String destinationCity = data.getStringExtra("DestinationCity");
            destination.setText(destinationCity);
        }else if(resultCode == 3){
            String inputDate = data.getStringExtra("Date");
            date.setText(inputDate);
        }
    }


    private void initializeView() {

        source=(TextView)findViewById(R.id.tv_source);
        destination=(TextView)findViewById(R.id.tv_destination);
        date=(TextView)findViewById(R.id.tv_date);
        swap=(ImageView)findViewById(R.id.iv_swap);
        search=(Button)findViewById(R.id.btn_search);

        Date todaysDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(sdf.format(todaysDate)+"");

        source.setOnClickListener(this);
        destination.setOnClickListener(this);
        date.setOnClickListener(this);
        swap.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Intent intent;
        if (view == source)
        {
            intent =new Intent(this,SourceCities.class);
            startActivityForResult(intent, 1);
        }
        else if(view==destination)
        {
            intent =new Intent(this,DestinationCities.class);
            startActivityForResult(intent, 2);

        }else if (view==swap)
        {
            String temp =source.getText()+"";
            source.setText(destination.getText()+"");
            destination.setText(temp);
        }
        else if (view==date){
            intent =new Intent(this,CalDroid.class);
            startActivityForResult(intent, 3);
        }
        else if (view==search){
            intent =new Intent(this,BusesWithFares.class);
            startActivity(intent);
        }
    }
}
