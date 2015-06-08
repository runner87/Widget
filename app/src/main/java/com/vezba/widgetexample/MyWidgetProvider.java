package com.vezba.widgetexample;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by Aleksandar Kostic on 8.4.2015.
 */
public class MyWidgetProvider extends AppWidgetProvider {
    private static final String ACTION_CLICK = "ACTION_CLICK";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

       Intent i = new Intent(context, ServiceWidget.class);
        i.putExtra("AppWidgetIDS", appWidgetIds);
        context.startService(i);

        AcaSinglton.getInstance().metoda();
    }

public static void novi(){
    AcaSinglton.getInstance().metoda();
}

}