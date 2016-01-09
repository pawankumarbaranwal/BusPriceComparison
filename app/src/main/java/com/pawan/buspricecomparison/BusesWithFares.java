package com.pawan.buspricecomparison;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BusesWithFares extends AppCompatActivity {

    private String sourceAndDestination;
    List<BusDetails> busDetailsList =new ArrayList<BusDetails>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        busDetailsList = getData();
        setContentView(R.layout.activity_buses_with_fares);

        TextView srcAndDestination=(TextView)findViewById(R.id.tv_src_and_destination);
        srcAndDestination.setText(sourceAndDestination);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.buslist);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(busDetailsList);
        recyclerView.setAdapter(adapter);
    }

    private List<BusDetails> getData() {
        List<BusDetails> list =new ArrayList<BusDetails>();
        /*BusDetails busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm","1000.00","RedBus","1100.00","MakeMyTrip","1220.00");
        list.add(busDetails);*/
        Intent i = getIntent();
        List<BusDetails> busesList = (List<BusDetails>) i.getSerializableExtra("ClearTripBusesList");
        Log.i("PaytmBuses123", "55555555555" + busesList.size());

 //       sourceAndDestination=busesList.get(1).getSourceCity()+" to "+busesList.get(1).getDestinationCity()+"  -  ";
        list.addAll(busesList);
        return list;
    }
}