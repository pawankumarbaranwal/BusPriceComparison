package com.pawan.buspricecomparison;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BusesWithFares extends AppCompatActivity {


    List<BusDetails> busDetailsList =new ArrayList<BusDetails>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        busDetailsList = getData();
        setContentView(R.layout.activity_buses_with_fares);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.buslist);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(busDetailsList);
        recyclerView.setAdapter(adapter);
    }

    private List<BusDetails> getData() {
        List<BusDetails> list =new ArrayList<BusDetails>();
        BusDetails busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);

        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);
        busDetails=new BusDetails("1","Sharma","Bangalore","Mumbai","10:40","18:40","VRL","Paytm",1000.00f,"RedBus",1100.00f,"MakeMyTrip",1200.00f);
        list.add(busDetails);

        return list;
    }
}