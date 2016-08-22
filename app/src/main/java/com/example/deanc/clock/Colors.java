package com.example.deanc.clock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by DeanC on 3/15/2016.
 */
public class Colors extends Activity{

    int colorSelected;
    String colorType;

    Button select_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().getExtras() != null) {
            colorType = getIntent().getExtras().getString("ColorType");
            colorSelected = getIntent().getExtras().getInt("SelectedColor");
        }
        if(colorType == null)colorType="NoType";
        Log.d("Clock", colorType);
        setContentView(R.layout.color_selection);

        select_color = (Button) findViewById(R.id.select_color);


    }

    public void goToMain(View view){
        Intent intent = (new Intent(this, MainActivity.class));
        intent.putExtra("ColorType", colorType);
        intent.putExtra("SelectedColor", colorSelected);
        startActivity(intent);
        finish();
    }

    public void buttonClicked(View view){

        //respond to menu item selection
        switch (view.getId()) {
            case R.id.red:
                this.colorSelected = Color.rgb(193,0,0);
                select_color.setText(R.string.s_red);
                break;
            case R.id.blue:
                this.colorSelected = Color.rgb(0,0,255);
                select_color.setText(R.string.s_blue);
                break;
            case R.id.cyan:
                this.colorSelected = Color.rgb(0,255,255);
                select_color.setText(R.string.s_cyan);
                break;
            case R.id.green:
                this.colorSelected = Color.rgb(0,180,0);
                select_color.setText(R.string.s_green);
                break;
            case R.id.yellow:
                this.colorSelected = Color.rgb(255,255,0);
                select_color.setText(R.string.s_yellow);
                break;
            case R.id.magenta:
                this.colorSelected = Color.rgb(255,0,255);
                select_color.setText(R.string.s_magenta);
                break;
            case R.id.white:
                this.colorSelected = Color.rgb(255,255,255);
                select_color.setText(R.string.s_white);
                break;
            case R.id.purple:
                this.colorSelected = Color.rgb(128,0,128);
                select_color.setText(R.string.s_purple);
                break;
            case R.id.gold:
                this.colorSelected = Color.rgb(255,215,0);
                select_color.setText(R.string.s_gold);
                break;
            case R.id.silver:
                this.colorSelected = Color.rgb(192,192,192);
                select_color.setText(R.string.s_silver);
                break;
            case R.id.bronze:
                this.colorSelected = Color.rgb(205,127,50);
                select_color.setText(R.string.s_bronze);
                break;
            case R.id.orange:
                this.colorSelected = Color.rgb(255,165,0);
                select_color.setText(R.string.s_orange);
                break;
            case R.id.indigo:
                this.colorSelected = Color.rgb(75, 0, 130);
                select_color.setText(R.string.s_indigo);
                break;
            case R.id.pink:
                this.colorSelected = Color.rgb(255,192,203);
                select_color.setText(R.string.s_pink);
                break;
            case R.id.black:
                this.colorSelected = Color.rgb(0,0,0);
                select_color.setText(R.string.s_black);
                break;
            case R.id.gray:
                this.colorSelected = Color.rgb(169,169,169);
                select_color.setText(R.string.s_gray);
                break;
        }
    }

}
