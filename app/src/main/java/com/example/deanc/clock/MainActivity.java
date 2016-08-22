package com.example.deanc.clock;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "MyClock";

    Segment hourTens, hourOnes, minuteTens, minuteOnes, secondTens, secondOnes;
    Colon colon_hm, colon_ms;
    TextView AmPm;

    public CounterClass timer;
    public colonBlink blinkTimer;

    int getItemID = 0;

    // Intent Variables
    static int clock_color = Color.RED;
    static int background_color = Color.BLACK;
    static boolean turnedOn;
    static String Time = "US/Eastern";

    int seconds, minutes, hours, ampm, militaryHours;

    RelativeLayout clock_main;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getExtras()!=null) {

            // Changing clock or background color depending on color type
            String colorType = getIntent().getExtras().getString("ColorType");
            if("ClockColor".equals(colorType)){
                clock_color =  getIntent().getExtras().getInt("SelectedColor");
            }
            if("BackgroundColor".equals(colorType)){
                background_color = getIntent().getExtras().getInt("SelectedColor");
            }

            // Changing time settings
            turnedOn = getIntent().getExtras().getBoolean("IsMilitary", turnedOn);

            Time = getIntent().getExtras().getString("TimeZone", Time);
        }

        clock_main = (RelativeLayout) findViewById(R.id.clock_main);
        clock_main.setBackgroundColor(background_color);

        menuButton = (Button) findViewById(R.id.menuButton);

        changeDigitColor();
        runClock();
        changeColon();

        timer = new CounterClass(60000, 100);
        timer.start();

        blinkTimer = new colonBlink(60000, 500);
        blinkTimer.start();

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(MainActivity.this, menuButton);
                popup.getMenuInflater()
                        .inflate(R.menu.menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        getItemID = item.getItemId();
                        Intent intent;

                        //respond to menu item selection
                        switch (item.getItemId()) {
                            case R.id.clock_color:
                                intent = (new Intent(MainActivity.this, Colors.class));
                                intent.putExtra("ColorType", "ClockColor");
                                intent.putExtra("SelectedColor", clock_color);
                                break;
                            case R.id.background_color:
                                intent = (new Intent(MainActivity.this, Colors.class));
                                intent.putExtra("ColorType", "BackgroundColor");
                                intent.putExtra("SelectedColor", background_color);
                                break;
                            case R.id.time_settings:
                                intent = (new Intent(MainActivity.this, Time_Zone.class));
                                intent.putExtra("IsMilitary", turnedOn);
                                intent.putExtra("TimeZone", Time);
                                break;

                            default:
                                return true;
                                //return super.onOptionsItemSelected(item);
                        }
                        startActivity(intent);
                        finish();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });

    }

    public void changeDigitColor(){

        hourTens = (Segment)findViewById(R.id.hour1);
        hourTens.setColor(clock_color);
        hourOnes = (Segment)findViewById(R.id.hour2);
        hourOnes.setColor(clock_color);
        minuteTens = (Segment)findViewById(R.id.minute1);
        minuteTens.setColor(clock_color);
        minuteOnes = (Segment)findViewById(R.id.minute2);
        minuteOnes.setColor(clock_color);

        AmPm = (TextView)findViewById(R.id.am_pm);
        AmPm.setTextColor(clock_color);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            secondTens = (Segment) findViewById(R.id.second1);
            secondTens.setColor(clock_color);
            secondOnes = (Segment) findViewById(R.id.second2);
            secondOnes.setColor(clock_color);
        }
    }

    public void runClock(){
        hourTens.setDigit(0);
        hourOnes.setDigit(0);
        minuteTens.setDigit(0);
        minuteOnes.setDigit(0);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            secondTens.setDigit(0);
            secondOnes.setDigit(0);
        }
    }

    public class CounterClass extends CountDownTimer {
        public CounterClass (long millisInFuture, long countDownInterval){
            super(millisInFuture,countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {

            Calendar calendar = new GregorianCalendar();
            Date trialTime = new Date();
            calendar.setTime(trialTime);
            TimeZone tz = TimeZone.getTimeZone(Time);
            calendar.setTimeZone(tz);
            
            seconds = calendar.get(Calendar.SECOND);
            minutes = calendar.get(Calendar.MINUTE);
            hours = calendar.get(Calendar.HOUR);
            militaryHours = calendar.get(Calendar.HOUR_OF_DAY);
            ampm = calendar.get(Calendar.AM_PM);

            if (hours == 0) hours = 12;

            if (turnedOn) {
                hours = militaryHours;
                AmPm.setTextColor(background_color);
            }

            hourTens.setDigit(hours/10);
            hourOnes.setDigit(hours%10);

            minuteTens.setDigit(minutes/10);
            minuteOnes.setDigit(minutes%10);

            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                secondTens.setDigit(seconds/10);
                secondOnes.setDigit(seconds%10);
            }

            if (ampm == Calendar.AM){
                AmPm.setText(R.string.am);
            }else if (ampm == Calendar.PM){
                AmPm.setText(R.string.pm);
            }
        }
        @Override
        public void onFinish() {
            timer.start();
        }
    }

    public class colonBlink extends CountDownTimer {
        public colonBlink (long millisInFuture, long countDownInterval){
            super(millisInFuture,countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {

            Log.d(TAG, "ColonBlink millisUntilFinished:"+millisUntilFinished);

            int colorTest = colon_hm.getColor();

            if (colorTest == clock_color){
                colon_hm.setColor(background_color);
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    colon_ms.setColor(background_color);
                }
            } else if (colorTest == background_color){
                colon_hm.setColor(clock_color);
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    colon_ms.setColor(clock_color);
                }
            }
        }
        @Override
        public void onFinish() {
            Log.d(TAG, "ColonBlink onFinish");
            blinkTimer.start();
        }
    }

    public void changeColon(){

        colon_hm = (Colon)findViewById(R.id.colon_hm);
        colon_hm.setColor(clock_color);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            colon_ms = (Colon) findViewById(R.id.colon_ms);
            colon_ms.setColor(clock_color);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        blinkTimer.cancel();
        timer.cancel();
        Log.d(TAG, "Stopped");
    }

}
