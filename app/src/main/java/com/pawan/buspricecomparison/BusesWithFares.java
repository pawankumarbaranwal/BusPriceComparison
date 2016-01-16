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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        Log.i("PaytmBuses123", "" + busesList.size());


        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object b1, Object b2) {
                BusDetails bus1 =(BusDetails)b1;
                BusDetails bus2 =(BusDetails)b2;


                if((bus1.getBusCompanyName().equalsIgnoreCase(bus2.getBusCompanyName()))&&
                        (bus1.getArrivalTime().equalsIgnoreCase(bus2.getArrivalTime()))&&
                        (bus1.getReachingTime().equalsIgnoreCase(bus2.getReachingTime()))
                        ){
                    Log.i("jjjjjjjj", bus1.getBusCompanyName() + "");
                    Log.i("jjjjjjjj", bus1.getArrivalTime() + "");
                    Log.i("jjjjjjjj", bus1.getReachingTime() + "");
                    Log.i("jjjjjjjj", bus2.getBusCompanyName() + "");
                    Log.i("jjjjjjjj", bus2.getArrivalTime() + "");
                    Log.i("jjjjjjjj", bus2.getReachingTime() + "");

                    return 0;
                }
                return 1;
            }
        });
        set.addAll(busesList);


        sourceAndDestination=busesList.get(1).getSourceCity()+" to "+busesList.get(1).getDestinationCity()+"  -  ";
        list.addAll(set);


        Collections.sort(list);
        Log.i("Set Size", set.size() + "");
        return list;
    }
}