package droidudes.hackathon.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import droidudes.hackathon.adapters.JobPostAdapter;
import droidudes.hackathon.common.Constants;
import droidudes.hackathon.factories.JobListFactory;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.JobPostBO;
import droidudes.hackathon.utilities.InternetOP;

public class JobListActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView noResultTv;
    private ProgressDialog mProgressDialog = null;
    private DatabaseReference mRef;
    private List<JobPostBO> jobPostBOList;
    private JobPostAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        mContext = JobListActivity.this;

        jobPostBOList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ///getJobListFromService();
                getJobListFromFactory();
            }
        });

        noResultTv = (TextView) findViewById(R.id.tv_no_result);

        if (mAdapter == null) {

            mAdapter = new JobPostAdapter(mContext, jobPostBOList, new OnRecyclerItemClick() {
                @Override
                public void onItemClicked(View view, int position) {
                    JobPostBO item = jobPostBOList.get(position);

                    Intent intent = new Intent(mContext,JobDetailActivity.class);

                    intent.putExtra("jobBOParcelable",item);
                    startActivity(intent);

                }
            });
        }
        mRecyclerView.setAdapter(mAdapter);
        ///getJobListFromService();
        getJobListFromFactory();
    }

    private void getJobListFromFactory(){
        jobPostBOList = new ArrayList<>();

        jobPostBOList = new JobListFactory().getJobPostBO();
        if(jobPostBOList != null && jobPostBOList.size() > 0)
            setDataToAdapter(jobPostBOList);

        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private void getJobListFromService(){
        if (InternetOP.isInternetAvailable(mContext)) {
            mProgressDialog = new ProgressDialog(mContext, R.style.MaterialDialog);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setTitle("Loading Trans Genders");
            mProgressDialog.setMessage("Please wait...");
            /*mProgressDialog = ProgressDialog.show(this, "Loading Subjects",
                    "Please wait...", true);*/

            jobPostBOList = new ArrayList<>();

            mRef = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(Constants.BASE_URL + "rootNode/subRootNode/joblist/");

            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    jobPostBOList.clear();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Log.e("Get Data", postSnapshot.getKey());

                        JobPostBO transBO = postSnapshot.getValue(JobPostBO.class);
                        //int levelNum = Integer.parseInt(postSnapshot.getKey());// +1
                        jobPostBOList.add(transBO);
                    }
                    setDataToAdapter(jobPostBOList);
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

        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private void setDataToAdapter(List<JobPostBO> jobList) {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();

        if (jobList != null && jobList.size() > 0) {
            noResultTv.setVisibility(View.GONE);
            mAdapter.setItemList(jobList);
        }
    }
}
