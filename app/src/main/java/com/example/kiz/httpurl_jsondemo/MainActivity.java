package com.example.kiz.httpurl_jsondemo;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextIsConnected;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextIsConnected = findViewById(R.id.text_is_connected);
        mRecyclerView = findViewById(R.id.recycler_view);

        if (isConnected()) {
            mTextIsConnected.setBackgroundColor(getResources().getColor(R.color.colorGreen, getTheme()));
            mTextIsConnected.setText(R.string.connected);
        } else {
            mTextIsConnected.setText(R.string.notConnected);
        }

        IAsyncResponse asyncResponse = new IAsyncResponse() {
            @Override
            public void processFinish(List<Repo> repos) {
                RepoAdapter repoAdapter = new RepoAdapter(MainActivity.this, repos);
                mRecyclerView.setAdapter(repoAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                        LinearLayoutManager.VERTICAL, false));
            }
        };
        new HttpAsyncTask(asyncResponse).execute();

    }

    private boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
