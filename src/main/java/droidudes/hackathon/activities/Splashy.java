package droidudes.hackathon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import droidudes.hackathon.R;

public class Splashy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashy);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashy.this,TransGenderListActivity.class);///TransGenderListActivity.class);
                startActivity(intent);
            }
        },1200);
    }
}
