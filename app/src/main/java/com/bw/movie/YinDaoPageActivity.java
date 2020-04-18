package com.bw.movie;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.http2.Http2Reader;

public class YinDaoPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao_page);
        final Intent localIntent = new Intent(this, MainActivity.class);
        Timer timer = new Timer();
        TimerTask tast = new TimerTask() {
            @Override
            public void run() {
                startActivity(localIntent);
            }
        };
        timer.schedule(tast, 3000);

    }


}
