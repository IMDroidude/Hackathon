package droidudes.hackathon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import droidudes.hackathon.R;
import droidudes.hackathon.adapters.TransGenderAdapter;
import droidudes.hackathon.common.KeyConst;
import droidudes.hackathon.factories.TransgenderBOFactory;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.TransGenderBO;
import droidudes.hackathon.utilities.RecyclerItemClickListener;

public class NewTransGenderListActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView noResultTv;
    private List<TransGenderBO> jobPostBOList;
    private TransGenderAdapter mAdapter = null;
    private Button submitSelectionBtn;

    private boolean isNGO = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trans_gender_list);

        mContext = NewTransGenderListActivity.this;

        jobPostBOList = new ArrayList<>();

        if (getIntent() != null) {
            isNGO = getIntent().getExtras().getBoolean(KeyConst.IS_NGO, false);
        }

        submitSelectionBtn = (Button) findViewById(R.id.btn_submit);
        submitSelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Candidates Confirm",Toast.LENGTH_LONG).show();
            }
        });
        /*submitSelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Candidates Confirm",Toast.LENGTH_LONG).show();
            }
        });*/

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        noResultTv = (TextView) findViewById(R.id.tv_no_result);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ///getJobListFromService();
                getJobListFromFactory();
            }
        });

        if (mAdapter == null) {
            mAdapter = new TransGenderAdapter(mContext, jobPostBOList, new OnRecyclerItemClick() {
                @Override
                public void onItemClicked(View view, int position) {
                    /*TransGenderBO item = jobPostBOList.get(position);

                    Intent intent = new Intent(mContext,JobDetailActivity.class);
                    intent.putExtra("jobBOParcelable",item);
                    startActivity(intent);*/
                }
            });
        }

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, mRecyclerView, new RecyclerItemClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TransGenderBO item = jobPostBOList.get(position);

                Intent intent = new Intent(mContext,CandidateProfileActivity.class);
                intent.putExtra("transGenderParcelable",item);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));
        ///getJobListFromService();
        getJobListFromFactory();

    }

    private void getJobListFromFactory() {


        jobPostBOList = new TransgenderBOFactory().getTransGenderList();
        if (jobPostBOList != null && jobPostBOList.size() > 0)
            setDataToAdapter();

        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

        mRecyclerView.setAdapter(mAdapter);
    }

    private void setDataToAdapter() {

        if (jobPostBOList != null && jobPostBOList.size() > 0) {
            noResultTv.setVisibility(View.GONE);
            mAdapter.setItemList(jobPostBOList);
        }
    }
}
