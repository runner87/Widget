package com.vezba.widgetexample;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by Aleksandar Kostic on 14.4.2015.
 */
public class ServiceWidget extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int[] allWidgetIds = intent.getIntArrayExtra("AppWidgetIDS");
        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100000));

            RemoteViews remoteViews = new RemoteViews(this.getPackageName(),
                    R.layout.widgetlayout);
            Log.w("WidgetExample", String.valueOf(number));
            // Set the text
            remoteViews.setTextViewText(R.id.update, String.valueOf(number));

            // Register an onClickListener
            Intent inOnClick = new Intent(this, MyWidgetProvider.class);

            inOnClick.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            inOnClick.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                    0, inOnClick, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
            AppWidgetManager.getInstance(this).updateAppWidget(widgetId, remoteViews);
            AcaSinglton.getInstance().metoda2();
            AcaSinglton.getInstance().metoda3();

        }

        return START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
