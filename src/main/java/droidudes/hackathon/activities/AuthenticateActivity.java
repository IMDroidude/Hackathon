package droidudes.hackathon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import droidudes.hackathon.R;
import droidudes.hackathon.common.KeyConst;

public class AuthenticateActivity extends AppCompatActivity {

    private Context mContext;
    private EditText emailEt, passwordEt;
    private TextView forgotPassTv;
    private Button loginBtn;
    private boolean isNGO = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);

        mContext = AuthenticateActivity.this;

        emailEt = (EditText) findViewById(R.id.et_email);
        passwordEt = (EditText) findViewById(R.id.et_password);

        forgotPassTv = (TextView) findViewById(R.id.tv_forgot_pass);

        if (getIntent() != null) {
            isNGO = getIntent().getExtras().getBoolean(KeyConst.IS_NGO, false);
        }

        forgotPassTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        loginBtn = (Button) findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailEt.getText().toString().equalsIgnoreCase("zar")
                        && passwordEt.getText().toString().equalsIgnoreCase("123")) {

                    if(isNGO == true){
                        Intent intent = new Intent(mContext,NgoJobListActivity.class);
                        intent.putExtra(KeyConst.IS_NGO, true);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(mContext,NgoJobListActivity.class);
                        intent.putExtra(KeyConst.IS_NGO, false);
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(mContext, "Email or Password wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
