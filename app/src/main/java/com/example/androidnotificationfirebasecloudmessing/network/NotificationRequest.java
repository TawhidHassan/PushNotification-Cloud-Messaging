package com.example.androidnotificationfirebasecloudmessing.network;

import com.example.androidnotificationfirebasecloudmessing.model.NotificationReq;
import com.example.androidnotificationfirebasecloudmessing.model.NotificationResponce;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificationRequest {
    @Headers({"Content-Type:application/json","Authorization:key=AAAALelp4VU:APA91bGEfUjalWBYO0UD9AeBvXINobD-UJMTAfR3bobn6ktBjYqjOP9AmU_7Q6v5EJYhrLX03nUeIVHd84E2giHCe1C0m3hR7kGWVJEI_z0kNqfyVmLfRwJnjwBXPxePJRIpkSBzWfw-"})
    @POST("send")
    Call<NotificationResponce> sent(@Body NotificationReq req);
}