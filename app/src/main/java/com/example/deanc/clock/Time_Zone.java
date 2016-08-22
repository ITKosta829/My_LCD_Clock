package com.example.deanc.clock;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Created by DeanC on 3/15/2016.
 */
public class Time_Zone extends Activity {

    Spinner spinner;
    Switch military;

    int hours, militaryHours;

    String spinnerSelection;

    HashMap <String, String> TZ;
    HashMap <String, Integer> TimeZoneIndex;


    Boolean turnedOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_zone);

        military = (Switch) findViewById(R.id.switch1);
        spinner = (Spinner) findViewById(R.id.TZSpinner);

        addItemsOnSpinner();

        if(getIntent().getExtras() != null) {

            turnedOn = getIntent().getExtras().getBoolean("IsMilitary");
            military.setChecked(turnedOn);

            spinnerSelection = getIntent().getExtras().getString("TimeZone");
            spinner.setSelection(TimeZoneIndex.get(spinnerSelection));
        }
        if(spinnerSelection == null)spinnerSelection = "NoSwitch";

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub


                spinnerSelection = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "selected " + spinnerSelection, Toast.LENGTH_LONG).show();
                /**** do your code*****/
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //
            }
        });

    }

    public void goToMain(View view){
        turnedOn = military.isChecked();
        Intent intent = (new Intent(this, MainActivity.class));
        intent.putExtra("IsMilitary", turnedOn);
        intent.putExtra("TimeZone", TZ.get(spinnerSelection));
        startActivity(intent);
        finish();
    }

    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.TZSpinner);
        List<String> list = new ArrayList<>();
        list.add("Pacific");
        list.add("Mountain");
        list.add("Central");
        list.add("Eastern");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        //spinner.setonIaddon

        TZ = new HashMap <>();
        TZ.put("Pacific", "US/Pacific");
        TZ.put("Mountain", "US/Mountain");
        TZ.put("Central", "US/Central");
        TZ.put("Eastern", "US/Eastern");

        TimeZoneIndex = new HashMap <>();
        TimeZoneIndex.put("US/Pacific", 0);
        TimeZoneIndex.put("US/Mountain", 1);
        TimeZoneIndex.put("US/Central", 2);
        TimeZoneIndex.put("US/Eastern", 3);
    }








}
