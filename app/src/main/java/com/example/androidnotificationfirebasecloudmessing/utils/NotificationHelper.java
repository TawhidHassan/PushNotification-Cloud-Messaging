package com.example.androidnotificationfirebasecloudmessing.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.androidnotificationfirebasecloudmessing.R;
import com.example.androidnotificationfirebasecloudmessing.ui.SendNotificationActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NotificationHelper {
    private Context context;
    private static final int id=100;

    public NotificationHelper(Context context) {
        this.context = context;
    }

    public void tiggerNotification(String title,String body){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());
    }


    //for image====================================================
    public void tiggerNotification(String title, String body, String image){
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBitmapFromURL(image)));

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());

    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//for image==========================================================================


    //for click action====================================================
    public void tiggerNotification(String title, String body, String image, String clickAction) {

        Intent intent = new Intent(clickAction);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBitmapFromURL(image)))
                .setContentIntent(pendingIntent);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());

    }
//for clcik action==========================================================================

    //for get data==========================================================================
    public void tiggerNotification(String title, String body, String image, String clickAction,String key1,String key2) {

        Intent intent = new Intent(clickAction);
        intent.putExtra("key1",key1);
        intent.putExtra("key2",key2);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBitmapFromURL(image)))
                .setContentIntent(pendingIntent);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());

    }
    //for get data==========================================================================
    //
    // for text==========================================================================
    public void tiggerNotification(String title, String body, String image, String clickAction,String key1,String key2,String text) {

        Intent intent = new Intent(context, SendNotificationActivity.class);
        intent.putExtra("key1",key1);
        intent.putExtra("key2",key2);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBitmapFromURL(image)).setBigContentTitle(text))
                .setContentIntent(pendingIntent);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());

    }

    // for text==========================================================================

}
