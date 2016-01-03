package com.pawan.buspricecomparison;

import android.content.Intent;
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
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.pawan.pojo.PaytmBuses;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchBuses extends AppCompatActivity implements View.OnClickListener {

    private TextView source, destination, date;
    private ImageView swap;
    private Button search;
    private Map<String, String> mParams = new HashMap<String, String>();
    static final String sTag = "tagPay";

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
        final Intent paytmIntent =new Intent(this,BusesWithFares.class);
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

            mParams.put("count","1");
            mParams.put("date",date.getText()+"");
            mParams.put("destination",destination.getText()+"");
            mParams.put("source",source.getText()+"");




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
                                            for (int i=0;i<paytmBusesList.size();i++)
                                            {
                                             PaytmBuses p =paytmBusesList.get(i);
                                                Log.i("PaytmBuses", "3333333" + p.getFare());
                                                Log.i("PaytmBuses", "3333333" + p.getAvalableSeats());
                                            }

                                            //setDataForPaytm(paytmBusesList);

                                            //intent =new Intent(this,BusesWithFares.class);
                                            paytmIntent.putExtra("PaytmBusesList", (Serializable) (setDataForPaytm(paytmBusesList)));
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
                                            //setToast(error);
                                        }
                                    }
                                    ,
                                    mParams,
                                    getString(R.string.paytmPostUrl)
                            );

            App.addRequest(gsonPostRequest, "tagPay");
        }else {
            //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        }

           // intent =new Intent(this,BusesWithFares.class);
         //   startActivity(intent);
        //}
    }
    private List<BusDetails> setDataForPaytm(@NonNull final List<PaytmBuses> paytmBusesList) {
    List<BusDetails> busList =new ArrayList<BusDetails>();
        for(int i=0;i<paytmBusesList.size();i++)
        {
            BusDetails busDetails =new BusDetails();
            busDetails.setPaytmDealer("Paytm");
            busDetails.setPaytmFare(paytmBusesList.get(i).getFare());
            busDetails.setBusCompanyName(paytmBusesList.get(i).getTravelsName());
            busDetails.setArrivalTime(paytmBusesList.get(i).getReportingTime());
            busList.add(busDetails);
        }
        return busList;
    }
}
