package com.example.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.example.myapplication.activity.UserInfoActivity;

public class UserInfoServiceImpl extends Service {
    public UserInfoServiceImpl(UserInfoActivity userInfoActivity) {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
