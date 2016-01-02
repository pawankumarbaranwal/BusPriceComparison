package com.pawan.buspricecomparison;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalDroid extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);


        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        //args.putInt(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, cal.get(java.util.Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.MONTH, cal.get(java.util.Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(java.util.Calendar.YEAR));
        //args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);
//        args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR,false);
        caldroidFragment.setArguments(args);
        caldroidFragment.setMinDate(cal.getTime());

        //caldroidFragment.setSixWeeksInCalendar(true);
        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.cal, caldroidFragment);
        //CalendarView c =(CalendarView)findViewById(R.id.cal);
       // c.setVisibility(View.INVISIBLE);

        t.commit();

        final Intent intent =new Intent(this,SearchBuses.class);
        final CaldroidListener listener = new CaldroidListener() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            // Intent intent =new Intent(this,SearchBuses.class);;
            @Override
            public void onSelectDate(Date date, View view) {
                Toast.makeText(getApplicationContext(), formatter.format(date),
                        Toast.LENGTH_SHORT).show();
                intent.putExtra("Date", formatter.format(date));
                setResult(3, intent);
                finish();
            }

     /*       @Override
            public void onChangeMonth(int month, int year) {
                String text = "month: " + month + " year: " + year;
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();
            }*/
/*
            @Override
            public void onLongClickDate(Date date, View view) {
                Toast.makeText(getApplicationContext(),
                        "Long click " + formatter.format(date),
                        Toast.LENGTH_SHORT).show();
            }*/

           /* @Override
            public void onCaldroidViewCreated() {
                Toast.makeText(getApplicationContext(),
                        "Caldroid view is created",
                        Toast.LENGTH_SHORT).show();
            }*/

        };

        caldroidFragment.setCaldroidListener(listener);
    }
}