package com.khiemtran.testwebview;

import android.app.Application;
import android.os.Bundle;

import com.facebook.FacebookSdk;

/**
 * Created by khiem.tran on 06/05/2016.
 */
public class DDSKApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        // Initialize the SDK before executing any other operations,
        // especially, if you're using Facebook UI elements.
    }

}
