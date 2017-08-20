package droidudes.hackathon.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import droidudes.hackathon.R;
import droidudes.hackathon.models.TransGenderBO;

public class CandidateProfileActivity extends AppCompatActivity {

    private TransGenderBO transGenderBO = null;
    private Context mContext;
    private TextView nameTv,ageTv,skilsTv,contactNumberTv,pastExperienceTv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_profile);

        mContext = CandidateProfileActivity.this;
        nameTv = (TextView) findViewById(R.id.tv_name);
        ageTv = (TextView) findViewById(R.id.tv_age);
        skilsTv = (TextView) findViewById(R.id.tv_skils);
        contactNumberTv = (TextView) findViewById(R.id.tv_contact_number);
        pastExperienceTv = (TextView) findViewById(R.id.tv_pas_experience);

        btn = (Button) findViewById(R.id.btn_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        if (getIntent() != null) {
            transGenderBO = getIntent().getExtras().getParcelable("transGenderParcelable");
        }

        if(transGenderBO != null){
            nameTv.setText("Name: " +transGenderBO.getName());
            ageTv.setText("Age: "+transGenderBO.getAge() + "");
            skilsTv.setText("Skills: "+transGenderBO.getSkills());
            contactNumberTv.setText("Phine#: "+ transGenderBO.getContactNumber());
            pastExperienceTv.setText("Past Experience: "+transGenderBO.getPastExperience());

        }
    }
}
