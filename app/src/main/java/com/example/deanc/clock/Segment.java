package com.example.deanc.clock;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by DeanC on 3/14/2016.
 */
public class Segment extends RelativeLayout {

    View seg_a, seg_b, seg_c, seg_d, seg_e, seg_f, seg_g;

    int on, off = Color.TRANSPARENT;

    public Segment(Context context, AttributeSet attrs) {

        super(context, attrs);

        inflate(context, R.layout.segment, this);

        seg_a = findViewById(R.id.seg_a);
        seg_b = findViewById(R.id.seg_b);
        seg_c = findViewById(R.id.seg_c);
        seg_d = findViewById(R.id.seg_d);
        seg_e = findViewById(R.id.seg_e);
        seg_f = findViewById(R.id.seg_f);
        seg_g = findViewById(R.id.seg_g);
    }

    public void setColor(int color){
        this.on = color;
    }

    public void setDigit(int number){
        switch (number){
            case 0:
                Zero();
                break;
            case 1:
                One();
                break;
            case 2:
                Two();
                break;
            case 3:
                Three();
                break;
            case 4:
                Four();
                break;
            case 5:
                Five();
                break;
            case 6:
                Six();
                break;
            case 7:
                Seven();
                break;
            case 8:
                Eight();
                break;
            case 9:
                Nine();
                break;
        }
    }

    public void Zero(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(on);
        seg_f.setBackgroundColor(on);
        seg_g.setBackgroundColor(off);
    }

    public void One(){
        seg_a.setBackgroundColor(off);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(off);
        seg_e.setBackgroundColor(off);
        seg_f.setBackgroundColor(off);
        seg_g.setBackgroundColor(off);
    }

    public void Two(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(off);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(on);
        seg_f.setBackgroundColor(off);
        seg_g.setBackgroundColor(on);
    }

    public void Three(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(off);
        seg_f.setBackgroundColor(off);
        seg_g.setBackgroundColor(on);
    }

    public void Four(){
        seg_a.setBackgroundColor(off);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(off);
        seg_e.setBackgroundColor(off);
        seg_f.setBackgroundColor(on);
        seg_g.setBackgroundColor(on);
    }

    public void Five(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(off);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(off);
        seg_f.setBackgroundColor(on);
        seg_g.setBackgroundColor(on);
    }

    public void Six(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(off);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(on);
        seg_f.setBackgroundColor(on);
        seg_g.setBackgroundColor(on);
    }

    public void Seven(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(off);
        seg_e.setBackgroundColor(off);
        seg_f.setBackgroundColor(off);
        seg_g.setBackgroundColor(off);
    }

    public void Eight(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(on);
        seg_f.setBackgroundColor(on);
        seg_g.setBackgroundColor(on);
    }

    public void Nine(){
        seg_a.setBackgroundColor(on);
        seg_b.setBackgroundColor(on);
        seg_c.setBackgroundColor(on);
        seg_d.setBackgroundColor(on);
        seg_e.setBackgroundColor(off);
        seg_f.setBackgroundColor(on);
        seg_g.setBackgroundColor(on);
    }
}
