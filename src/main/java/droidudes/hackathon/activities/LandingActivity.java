package droidudes.hackathon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import droidudes.hackathon.R;
import droidudes.hackathon.common.KeyConst;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button ngoBtn, employeerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mContext = LandingActivity.this;

        ngoBtn = (Button) findViewById(R.id.btn_ngo);
        employeerBtn = (Button) findViewById(R.id.btn_employeer);

        ngoBtn.setOnClickListener(this);
        employeerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ngo:
                Intent intent = new Intent(mContext, AuthenticateActivity.class);
                intent.putExtra(KeyConst.IS_NGO, true);
                startActivity(intent);
                break;
            case R.id.btn_employeer:
                Intent emplntent = new Intent(mContext, AuthenticateActivity.class);
                emplntent.putExtra(KeyConst.IS_NGO, false);
                startActivity(emplntent);
                break;
        }
    }
}
