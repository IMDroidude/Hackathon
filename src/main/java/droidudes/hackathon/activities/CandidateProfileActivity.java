package droidudes.hackathon.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import droidudes.hackathon.R;
import droidudes.hackathon.models.TransGenderBO;

public class CandidateProfileActivity extends AppCompatActivity {

    private TransGenderBO transGenderBO = null;
    private TextView nameTv,ageTv,skilsTv,contactNumberTv,pastExperienceTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_profile);

        nameTv = (TextView) findViewById(R.id.tv_name);
        ageTv = (TextView) findViewById(R.id.tv_age);
        skilsTv = (TextView) findViewById(R.id.tv_skils);
        contactNumberTv = (TextView) findViewById(R.id.tv_contact_number);
        pastExperienceTv = (TextView) findViewById(R.id.tv_pas_experience);

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
