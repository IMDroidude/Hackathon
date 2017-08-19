package droidudes.hackathon.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import droidudes.hackathon.R;
import droidudes.hackathon.common.Constants;

/**
 * Created by Zare Ahmed on 18-Aug-17.
 */
public class FirebaseActivity extends AppCompatActivity {

    private Context mContext;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        callService();
    }

    private void callService(){

        mRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl(Constants.BASE_URL + "rootNode/subRoot/mcqRoot/");

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ///levelsList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Log.e("Get Data", postSnapshot.getKey());

                    //int levelNum = Integer.parseInt(postSnapshot.getKey());// +1
                    ///levelsList.add(new LevelBO(levelNum + ""));
                }
                ///setDataToAdapter(levelsList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(mContext,
                        databaseError.getMessage() + "  " + databaseError.getDetails()
                        , Toast.LENGTH_LONG).show();
            }
        });
    }
}
