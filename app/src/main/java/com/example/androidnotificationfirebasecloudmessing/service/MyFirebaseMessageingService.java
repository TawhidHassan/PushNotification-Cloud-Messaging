package com.example.androidnotificationfirebasecloudmessing.service;

import androidx.annotation.NonNull;

import com.example.androidnotificationfirebasecloudmessing.utils.NotificationHelper;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessageingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String body= remoteMessage.getNotification().getBody();
        String title= remoteMessage.getNotification().getTitle();
        String image= remoteMessage.getNotification().getImageUrl() != null ? remoteMessage.getNotification().getImageUrl().toString():null;
        String clickAction = remoteMessage.getNotification().getClickAction();

          String key1 = remoteMessage.getData().get("key1");
          String key2 = remoteMessage.getData().get("key2");
          String text = remoteMessage.getData().get("text");

        NotificationHelper helper=new NotificationHelper(this);
        helper.tiggerNotification(title,body);
        helper.tiggerNotification(title,body,image);
        helper.tiggerNotification(title,body,image,clickAction);
        helper.tiggerNotification(title,body,image,clickAction,key1,key2);
        helper.tiggerNotification(title,body,image,clickAction,key1,key2,text);
    }
}
