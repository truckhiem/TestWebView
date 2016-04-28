package com.khiemtran.testwebview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "asdasdasd";
    public static String KEY_1 = "asd";
    private Context context;
    private String url = "http://diadiemsukien.com/";
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
//        dialog = new ProgressDialog(context, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
//        dialog.show();
        setContentView(R.layout.activity_main);
        String extraUrl = getIntent().getStringExtra(KEY_1);
        if(extraUrl != null && !extraUrl.isEmpty()){
            url = extraUrl;
        }
        WebView wv = (WebView) findViewById(R.id.webview);
        wv.loadUrl(url);
        wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wv.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "Processing webview url click...");
                Intent i = new Intent(context, MainActivity.class);
                i.putExtra(KEY_1, url);
                context.startActivity(i);
                ((Activity) context).overridePendingTransition(R.anim.move_right_in, R.anim.move_left_out);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                Log.i(TAG, "Finished loading URL: " + url);
//                if(dialog.isShowing())
//                    dialog.dismiss();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e(TAG, "Error: " + description);
//                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
//                alertDialog.setTitle("Error");
//                alertDialog.setMessage(description);
//                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                });
//                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        ((Activity) context).overridePendingTransition(R.anim.move_left_in, R.anim.move_right_out);
    }
}
