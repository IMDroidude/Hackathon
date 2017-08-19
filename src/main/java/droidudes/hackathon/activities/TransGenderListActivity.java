package droidudes.hackathon.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import droidudes.hackathon.R;
import droidudes.hackathon.adapters.TransGenderAdapter;
import droidudes.hackathon.common.Constants;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.TransGenderBO;
import droidudes.hackathon.utilities.InternetOP;

/**
 * Created by Zare Ahmed on 17-Aug-17.
 */
public class TransGenderListActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView noResultTv;
    private ProgressDialog mProgressDialog;
    private DatabaseReference mRef;
    private List<TransGenderBO> transGenderList;
    private TransGenderAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);

        mContext = TransGenderListActivity.this;

        transGenderList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getTransGenderListFromService();
            }
        });

        noResultTv = (TextView) findViewById(R.id.tv_no_result);

        if (mAdapter == null) {

            mAdapter = new TransGenderAdapter(mContext, transGenderList, new OnRecyclerItemClick() {
                @Override
                public void onItemClicked(View view, int position) {

                    /*Intent intent = new Intent(mContext, McqActivity.class);
                    startActivity(intent);*/
                }
            });
        }
        mRecyclerView.setAdapter(mAdapter);
        getTransGenderListFromService();
    }

    private void getTransGenderListFromService(){
        if (InternetOP.isInternetAvailable(mContext)) {
            mProgressDialog = new ProgressDialog(mContext, R.style.MaterialDialog);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setTitle("Loading Trans Genders");
            mProgressDialog.setMessage("Please wait...");
            /*mProgressDialog = ProgressDialog.show(this, "Loading Subjects",
                    "Please wait...", true);*/

            transGenderList = new ArrayList<>();

            mRef = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(Constants.BASE_URL + "rootNode/subRootNode/main/");

            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    transGenderList.clear();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Log.e("Get Data", postSnapshot.getKey());

                        TransGenderBO transBO = postSnapshot.getValue(TransGenderBO.class);
                        //int levelNum = Integer.parseInt(postSnapshot.getKey());// +1
                        transGenderList.add(transBO);
                    }
                    setDataToAdapter(transGenderList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    if (mProgressDialog != null)
                        mProgressDialog.dismiss();

                    Toast.makeText(mContext,
                            databaseError.getMessage() + "  " + databaseError.getDetails()
                            , Toast.LENGTH_LONG).show();
                }
            });
        } else {
            noResultTv.setVisibility(View.VISIBLE);
            noResultTv.setText(getString(R.string.internet_na));
        }

        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private void setDataToAdapter(List<TransGenderBO> levelsList) {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();

        if (levelsList != null && levelsList.size() > 0) {
            noResultTv.setVisibility(View.GONE);
            mAdapter.setItemList(levelsList);
        }
    }
}
