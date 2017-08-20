package droidudes.hackathon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import droidudes.hackathon.R;
import droidudes.hackathon.common.KeyConst;
import droidudes.hackathon.models.JobPostBO;

public class JobDetailActivity extends AppCompatActivity {

    private Context mContext;
    private JobPostBO jobPostBO = null;
    private TextView jobTitleTv, companyNameTv, workLocationTv,
            skillNeededTv, workHourTv,detailDescTv,salaryTv;
    private Button doneBtn;
    private boolean isNGO = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        mContext = JobDetailActivity.this;

        if (getIntent() != null) {
            isNGO = getIntent().getExtras().getBoolean(KeyConst.IS_NGO, false);
        }

        jobTitleTv = (TextView) findViewById(R.id.tv_job_title);
        companyNameTv = (TextView) findViewById(R.id.tv_company_name);

        workLocationTv = (TextView) findViewById(R.id.tv_work_location);
        skillNeededTv = (TextView) findViewById(R.id.tv_skill_needed);

        workHourTv = (TextView) findViewById(R.id.tv_work_hours);
        detailDescTv = (TextView) findViewById(R.id.tv_detail_desc);

        salaryTv = (TextView) findViewById(R.id.tv_salary);

        doneBtn = (Button) findViewById(R.id.btn_detail);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewTransGenderListActivity.class);
                intent.putExtra(KeyConst.IS_NGO, isNGO);
                startActivity(intent);
            }
        });

        if (getIntent() != null) {
            jobPostBO = getIntent().getExtras().getParcelable("jobBOParcelable");
        }

        if (jobPostBO != null) {
            jobTitleTv.setText(jobPostBO.getJobTitle());
            companyNameTv.setText("Posted By : " + jobPostBO.getCompanyName());

            workLocationTv.setText("Location : " + jobPostBO.getWorkLocation());
            skillNeededTv.setText("Required skill: " + jobPostBO.getSkillNeeded());

            workHourTv.setText("Working Hours: " +jobPostBO.getWorkHours());
            ///detailDescTv.setText(jobPostBO.getDetailDesc());
            salaryTv.setText("Salary : " + jobPostBO.getSalary());
        }
    }
}
