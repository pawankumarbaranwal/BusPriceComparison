package com.pawan.buspricecomparison;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.pawan.pojo.ClearTripBus;
import com.pawan.pojo.PaytmBuses;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SearchBuses extends AppCompatActivity implements View.OnClickListener {

    private TextView source, destination, date;
    private ImageView swap;
    private Button search;
    private Map<String, String> mParams = new HashMap<String, String>();
    static final String sTag = "tagPay";
    private String clearTripDate;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat clearTripFormat = new SimpleDateFormat("dd/MM/yyyy");
    List<BusDetails> allBuses =new ArrayList<BusDetails>();
    final boolean[] finished = {false};
    Object mLock=new Object();


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
            try {
                clearTripDate=clearTripFormat.format(sdf.parse(inputDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
    }


    private void initializeView() {

        source=(TextView)findViewById(R.id.tv_source);
        destination=(TextView)findViewById(R.id.tv_destination);
        date=(TextView)findViewById(R.id.tv_date);
        swap=(ImageView)findViewById(R.id.iv_swap);
        search=(Button)findViewById(R.id.btn_search);

        Date todaysDate = Calendar.getInstance().getTime();
        clearTripDate=clearTripFormat.format(todaysDate);

        date.setText(sdf.format(todaysDate)+"");

        source.setOnClickListener(this);
        destination.setOnClickListener(this);
        date.setOnClickListener(this);
        swap.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        final Intent paytmIntent = new Intent(this, BusesWithFares.class);
        if (view == source) {
            intent = new Intent(this, SourceCities.class);
            startActivityForResult(intent, 1);
        } else if (view == destination) {
            intent = new Intent(this, DestinationCities.class);
            startActivityForResult(intent, 2);

        } else if (view == swap) {
            String temp = source.getText() + "";
            source.setText(destination.getText() + "");
            destination.setText(temp);
        } else if (view == date) {
            intent = new Intent(this, CalDroid.class);
            startActivityForResult(intent, 3);
        } else if (view == search) {

            //paytmRequest();
           cleartipRequest();

            /*paytmIntent.putExtra("ClearTripBusesList", (Serializable) allBuses);
            startActivity(paytmIntent);*/

           // RequestQueue serialRequestQueue=p

            /*mParams.put("count", "1");
            mParams.put("date", date.getText() + "");
            mParams.put("destination", destination.getText() + "");
            mParams.put("source", source.getText() + "");


            Log.i("iiiiiiiiiiiiiiiii", getString(R.string.clearTripUrl) + "from=" + source.getText() + "&to=" + destination.getText() + "&date=" + clearTripDate);
            final GsonGetRequest<List<ClearTripBus>> gsonGetRequest = ApiRequests.getObject(
                    getString(R.string.clearTripUrl) + "from=" + source.getText() + "&to=" + destination.getText() + "&date=" + clearTripDate,
                    new Response.Listener<List<ClearTripBus>>() {
                        @Override
                        public void onResponse(List<ClearTripBus> clearTripBuses) {
                            // Deal with the DummyObject here
                            // mProgressBar.setVisibility(View.GONE);
                            // mContent.setVisibility(View.VISIBLE);
                            Log.i("SuccessMessage", "" + clearTripBuses.size());
                            setDataForClearTrip(clearTripBuses);
                            //     paytmIntent.putExtra("ClearTripBusesList", (Serializable) (setDataForClearTrip(clearTripBuses)));
                            //    startActivity(paytmIntent);

                        }
                    }
                    ,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Deal with the error here
                            // mProgressBar.setVisibility(View.GONE);
                            //mErrorView.setVisibility(View.VISIBLE);
                            Log.i("ErrorMessage", "4");
                            //setToast(error);
                        }
                    }
            );
            //gsonGetRequest.setPriority(Request.Priority.IMMEDIATE);
            App.addRequest(gsonGetRequest, "tagPay");


            Log.i("Outside ClearTrip", "3333333");
        }
            final GsonPostRequest<PaytmBuses[]> gsonPostRequest =
                    ApiRequests.getPayObjectArrayWithPost
                            (
                                    new Response.Listener<PaytmBuses[]>() {
                                        @Override
                                        public void onResponse(PaytmBuses[] paytmBuses) {
                                            // Deal with the DummyObject here
                                            // mProgressBar.setVisibility(View.GONE);
                                            // mContent.setVisibility(View.VISIBLE);
                                            Log.i("SuccessMessage", "3" + paytmBuses);
                                            List<PaytmBuses> paytmBusesList = Arrays.asList(paytmBuses);
                                            for (int i = 0; i < paytmBusesList.size(); i++) {
                                                PaytmBuses p = paytmBusesList.get(i);
                                                Log.i("PaytmBuses", "3333333" + p.getFare());
                                                Log.i("PaytmBuses", "3333333" + p.getAvalableSeats());
                                            }

                                            setDataForPaytm(paytmBusesList);

                                            //intent =new Intent(this,BusesWithFares.class);
                                            //            paytmIntent.putExtra("PaytmBusesList", (Serializable) (setDataForPaytm(paytmBusesList)));
                                            //             startActivity(paytmIntent);

                                        }
                                    }
                                    ,
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            // Deal with the error here
                                            // mProgressBar.setVisibility(View.GONE);
                                            //mErrorView.setVisibility(View.VISIBLE);
                                            Log.i("ErrorMessage", "4");
                                            //setToast(error);
                                        }
                                    }
                                    ,
                                    mParams,
                                    getString(R.string.paytmPostUrl)
                            );

            App.addRequest(gsonPostRequest, "tagPay");*/
        //}
/*
  else {
            //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        }
*/

            // intent =new Intent(this,BusesWithFares.class);
            //   startActivity(intent);
            //}
        /*if (allBuses.size()!=0) {
            Log.i("Outside Paytm", "4444444");
            startActivity(paytmIntent);
            paytmIntent.putExtra("ClearTripBusesList", (Serializable) (allBuses));
        }*/
        }
    }
    private void paytmRequest(){
        final Intent paytmIntent = new Intent(this, BusesWithFares.class);
        mParams.put("count", "1");
        mParams.put("date", date.getText() + "");
        mParams.put("destination", destination.getText() + "");
        mParams.put("source", source.getText() + "");

        final GsonPostRequest<PaytmBuses[]> gsonPostRequest =
                ApiRequests.getPayObjectArrayWithPost
                        (
                                new Response.Listener<PaytmBuses[]>() {
                                    @Override
                                    public void onResponse(PaytmBuses[] paytmBuses) {
                                        // Deal with the DummyObject here
                                        // mProgressBar.setVisibility(View.GONE);
                                        // mContent.setVisibility(View.VISIBLE);
                                        Log.i("SuccessMessage", "3" + paytmBuses);
                                        List<PaytmBuses> paytmBusesList = Arrays.asList(paytmBuses);
                                        for (int i = 0; i < paytmBusesList.size(); i++) {
                                            PaytmBuses p = paytmBusesList.get(i);
                                            Log.i("PaytmBuses", "3333333" + p.getFare());
                                            Log.i("PaytmBuses", "3333333" + p.getAvalableSeats());
                                        }



                                        setDataForPaytm(paytmBusesList);
                                        paytmIntent.putExtra("ClearTripBusesList", (Serializable) allBuses);
                                        startActivity(paytmIntent);


                                    }
                                }
                                ,
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // Deal with the error here
                                        // mProgressBar.setVisibility(View.GONE);
                                        //mErrorView.setVisibility(View.VISIBLE);
                                        Log.i("ErrorMessage", "4");
                                        paytmIntent.putExtra("ClearTripBusesList", (Serializable) allBuses);
                                        startActivity(paytmIntent);
                                        //setToast(error);

                                    }
                                }
                                ,
                                mParams,
                                getString(R.string.paytmPostUrl)
                        );

        App.addRequest(gsonPostRequest, "tagPay");
    }

    private void cleartipRequest(){

        final Intent paytmIntent = new Intent(this, BusesWithFares.class);
        Log.i("iiiiiiiiiiiiiiiii", getString(R.string.clearTripUrl) + "from=" + source.getText() + "&to=" + destination.getText() + "&date=" + clearTripDate);
        final GsonGetRequest<List<ClearTripBus>> gsonGetRequest = ApiRequests.getObject(
                getString(R.string.clearTripUrl) + "from=" + source.getText() + "&to=" + destination.getText() + "&date=" + clearTripDate,
                new Response.Listener<List<ClearTripBus>>() {
                    @Override
                    public void onResponse(List<ClearTripBus> clearTripBuses) {
                        // Deal with the DummyObject here
                        // mProgressBar.setVisibility(View.GONE);
                        // mContent.setVisibility(View.VISIBLE);
                        Log.i("SuccessMessage", "" + clearTripBuses.size());
                        setDataForClearTrip(clearTripBuses);

                        //     paytmIntent.putExtra("ClearTripBusesList", (Serializable) (setDataForClearTrip(clearTripBuses)));
                        //    startActivity(paytmIntent);
                        //paytmIntent.putExtra("ClearTripBusesList", (Serializable) allBuses);
                        ///startActivity(paytmIntent);
                        paytmRequest();
                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Deal with the error here
                        // mProgressBar.setVisibility(View.GONE);
                        //mErrorView.setVisibility(View.VISIBLE);
                        Log.i("ErrorMessage", "4");

                        //setToast(error);
                    }
                }
        );
        //gsonGetRequest.setPriority(Request.Priority.IMMEDIATE);
        App.addRequest(gsonGetRequest, "tagPay");


        Log.i("Outside ClearTrip", "3333333");
    }


    private List<BusDetails> setDataForClearTrip(List<ClearTripBus> clearTripBuses) {


        Log.i("Insidecleartip", "4444444");
        List<BusDetails> busList =new ArrayList<BusDetails>();
        for(int i=0;i<clearTripBuses.size();i++)
        {

            long rTime=Long.parseLong(clearTripBuses.get(i).getAt());
            long dTime=Long.parseLong(clearTripBuses.get(i).getDt());

            SimpleDateFormat sdf = new SimpleDateFormat("HH-mm");

            //Converting milliseconds to Date using Calendar
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(dTime);

            BusDetails busDetails =new BusDetails();
            busDetails.setCleartripDealer("ClearTrip");
            busDetails.setSourceCity(source.getText() + "");
            busDetails.setDestinationCity(destination.getText() + "");
            busDetails.setCleartripFare(clearTripBuses.get(i).getCv().getF());
            busDetails.setBusCompanyName(clearTripBuses.get(i).getCv().getOn());
            busDetails.setArrivalTime(sdf.format(cal.getTime()));
            cal.setTimeInMillis(rTime);
            busDetails.setReachingTime(sdf.format(cal.getTime()));
            busList.add(busDetails);
        }
        allBuses.addAll(busList);
        return busList;
    }

    private void setDataForPaytm(@NonNull final List<PaytmBuses> paytmBusesList) {
    List<BusDetails> busList =new ArrayList<BusDetails>();
    boolean var =false;
        List<BusDetails> removeAll=new ArrayList<BusDetails>();
        List<BusDetails> addAll =new ArrayList<BusDetails>();


        for (BusDetails busDetails : allBuses) {
            Log.i("Size",allBuses.size()+"");
            BusDetails bus=new BusDetails();
            innerloop:
            for (PaytmBuses paytmBuses : paytmBusesList) {
                var =false;
                String arrivalTime=paytmBuses.getDepartureTime().substring(0, 2)+"-"+paytmBuses.getDepartureTime().substring(2, 4);
                String reachingTime=paytmBuses.getArrivalTime().substring(0, 2)+"-"+paytmBuses.getArrivalTime().substring(2,4);


                bus.setPaytmDealer("Paytm");
                bus.setSourceCity(source.getText()+"");
                bus.setDestinationCity(destination.getText() + "");
                bus.setArrivalTime(arrivalTime);
                bus.setReachingTime(reachingTime);
                bus.setPaytmFare(paytmBuses.getFare());
                bus.setBusCompanyName(paytmBuses.getTravelsName());
                busList.add(busDetails);

                Log.i("lllllllllll", busDetails.getBusCompanyName() + "");
                Log.i("lllllllllll", paytmBuses.getTravelsName() + "");
                Log.i("lllllllllll", busDetails.getArrivalTime() + "");
                Log.i("lllllllllll", arrivalTime + "");
                Log.i("lllllllllll", busDetails.getReachingTime() + "");
                Log.i("lllllllllll", reachingTime + "");
                 // if ((((busDetails.getBusCompanyName()).replaceAll("\\s+","")).equalsIgnoreCase(((paytmBuses.getTravelsName()).replaceAll("\\s+",""))))&&
                if ((busDetails.getBusCompanyName().equals(paytmBuses.getTravelsName()))&&
                        (busDetails.getArrivalTime().equals(arrivalTime))&&
                        (busDetails.getReachingTime().equals(reachingTime)))
                {/*
                    System.out.println(busDetails.getPaytmDealer());
                    System.out.println(busDetails.getCleartripDealer());
                    System.out.println(paytmBuses.getPaytmDealer());
                    System.out.println(paytmBuses.getCleartripDealer());*/


                    bus.setCleartripDealer("Cleartrip");
                    bus.setCleartripFare(busDetails.getCleartripFare());
                    removeAll.add(busDetails);
                    addAll.add(bus);
                    var=true;
                    break innerloop;
                }
            }
            if (var==false)
            {
                addAll.add(bus);
            }
        }
        Log.i("removeAllSize",removeAll.size()+"");
        Log.i("addAllSize",addAll.size()+"");
        Log.i("Size",allBuses.size()+"");
        allBuses.removeAll(removeAll);
        Log.i("Size", allBuses.size() + "");
        allBuses.addAll(addAll);
        Log.i("Size", allBuses.size() + "");
    }
}
