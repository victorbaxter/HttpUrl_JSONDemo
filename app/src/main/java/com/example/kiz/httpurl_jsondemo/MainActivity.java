package com.example.kiz.httpurl_jsondemo;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvIsConnected;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get reference to the views
        tvIsConnected = findViewById(R.id.tvIsConnected);
        recyclerView = findViewById(R.id.recycler_view);

        // check if you are connected to the internet or not
        if (isConnected()) {
            tvIsConnected.setBackgroundColor(getResources().getColor(R.color.colorGreen, getTheme()));
            tvIsConnected.setText(R.string.connected);
        } else {
            tvIsConnected.setText(R.string.notConnected);
        }

        new HttpAsyncTask(recyclerView, MainActivity.this).execute();
    }

    private boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
