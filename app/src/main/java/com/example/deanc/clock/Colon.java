package com.example.deanc.clock;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by DeanC on 3/14/2016.
 */
public class Colon extends RelativeLayout {

    View colon_top, colon_bot;

    int color = 0;



    public Colon (Context context, AttributeSet attrs) {

        super(context, attrs);

        inflate(context, R.layout.colon, this);

        colon_top = findViewById(R.id.colon_top);
        colon_bot = findViewById(R.id.colon_bottom);
    }

    public void setColor(int color){
        colon_top.setBackgroundColor(color);
        colon_bot.setBackgroundColor(color);
        this.color=color;
    }

    public int getColor (){
        return this.color;
    }

}
