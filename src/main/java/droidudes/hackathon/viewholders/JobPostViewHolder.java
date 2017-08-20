package droidudes.hackathon.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import droidudes.hackathon.R;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.JobPostBO;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class JobPostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnRecyclerItemClick onRecyclerItemClick;
    private TextView jobTitleTv, postDateTv, skillNeededTv, detailDescTv;

    public JobPostViewHolder(View itemView, OnRecyclerItemClick onRecyclerItemClick) {
        super(itemView);
        this.onRecyclerItemClick = onRecyclerItemClick;

        jobTitleTv = (TextView) itemView.findViewById(R.id.tv_job_title);
        postDateTv = (TextView) itemView.findViewById(R.id.tv_post_date);

        skillNeededTv = (TextView) itemView.findViewById(R.id.tv_skill_needed);
        detailDescTv = (TextView) itemView.findViewById(R.id.tv_detail_desc);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (onRecyclerItemClick != null)
            onRecyclerItemClick.onItemClicked(v, getAdapterPosition());
    }

    public void bindData(JobPostBO item) {
        if (item != null) {
            jobTitleTv.setText(item.getJobTitle());
            skillNeededTv.setText(item.getSkillNeeded());
            ///detailDescTv.setText(item.getDetailDesc());
            ////postDateTv.setText(item.getWorkHours());
        }
    }
}
