package droidudes.hackathon.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import droidudes.hackathon.R;

public class CreateJobActivity extends AppCompatActivity {

    private Context mContext;
    private EditText jobNameEt, workHourEt, skillsEt;
    private Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);

        mContext = CreateJobActivity.this;

        jobNameEt = (EditText) findViewById(R.id.et_job_name);
        workHourEt = (EditText) findViewById(R.id.et_work_hour);
        skillsEt = (EditText) findViewById(R.id.et_skills);

        doneBtn = (Button) findViewById(R.id.btn_done);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postJob();
            }
        });
    }

    private void postJob() {
        if (!jobNameEt.getText().toString().isEmpty()
                && !workHourEt.getText().toString().isEmpty()
                && !skillsEt.getText().toString().isEmpty()) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(mContext, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(mContext);
            }
            builder.setTitle("Make Payment")
                    .setMessage("Post job")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            Toast.makeText(mContext, "Some fields are misisng", Toast.LENGTH_LONG).show();
        }
    }
}
