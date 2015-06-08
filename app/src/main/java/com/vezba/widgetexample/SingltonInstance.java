package com.vezba.widgetexample;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Aleksandar Kostic on 5.6.2015.
 */
public class SingltonInstance extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singlton(){
        AcaSinglton.getInstance().metoda();
    }



    }
