package droidudes.hackathon.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import droidudes.hackathon.R;

public class SignUpActivity extends AppCompatActivity {

    private Context mContext;
    private EditText companyNameEt, ntnEt, nicEt, emailEt, passwordEt;
    private Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mContext = SignUpActivity.this;

        companyNameEt = (EditText) findViewById(R.id.et_company_name);
        ntnEt = (EditText) findViewById(R.id.et_ntn);
        nicEt = (EditText) findViewById(R.id.et_nic);
        emailEt = (EditText) findViewById(R.id.et_email);
        passwordEt = (EditText) findViewById(R.id.et_password);

        doneBtn = (Button) findViewById(R.id.btn_done);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void singUp(){

    }
}
