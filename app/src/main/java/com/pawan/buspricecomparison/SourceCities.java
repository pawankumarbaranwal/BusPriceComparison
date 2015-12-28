package com.pawan.buspricecomparison;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SourceCities extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_cities);
        AutoCompleteTextView autoCompleteCities = (AutoCompleteTextView) findViewById(R.id.tv_autocomplete_city);

        String[] cities = getResources().getStringArray(R.array.cities_array);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);
        autoCompleteCities.setAdapter(adapter);

        final Intent intent =new Intent(this,SearchBuses.class);
        autoCompleteCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                String cityName = (String) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                //bundle.putString("SourceCity", cityName);
                intent.putExtra("SourceCity", cityName);
                Log.i("City Name",cityName);

                setResult(1, intent);
                finish();
                //intent.putExtras(bundle);
                //startActivity(intent);

            }
        });
    }
}