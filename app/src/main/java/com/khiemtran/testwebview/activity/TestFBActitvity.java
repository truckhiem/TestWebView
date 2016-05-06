package com.khiemtran.testwebview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.khiemtran.testwebview.R;
import com.khiemtran.testwebview.abstracts.BaseActivity;

/**
 * Created by khiem.tran on 06/05/2016.
 */
public class TestFBActitvity extends BaseActivity {

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        super.onCreate(savedInstanceState);
//        LoginButton loginButton = (LoginButton) findViewById(R.id.usersettings_fragment_login_button);
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {});
//        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void initView() {
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
//        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.d("login Facebook","User ID: "
                        + loginResult.getAccessToken().getUserId()
                        + "\n" +
                        "Auth Token: "
                        + loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                // App code
                Log.d("login Facebook","onCancel");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d("login Facebook",exception.toString());
            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_testfb;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
