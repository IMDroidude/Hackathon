package droidudes.hackathon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import droidudes.hackathon.R;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.JobPostBO;
import droidudes.hackathon.viewholders.JobPostViewHolder;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class JobPostAdapter extends RecyclerView.Adapter<JobPostViewHolder> {

    private Context mContext;
    private List<JobPostBO> itemList;
    private OnRecyclerItemClick onRecyclerItemClick;

    public JobPostAdapter(Context mContext, List<JobPostBO> itemList, OnRecyclerItemClick onRecyclerItemClicking) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.onRecyclerItemClick = onRecyclerItemClicking;
    }

    @Override
    public JobPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.item_job_post_list,
                parent, false);
        return new JobPostViewHolder(mView, onRecyclerItemClick);
    }

    @Override
    public void onBindViewHolder(JobPostViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(List<JobPostBO> newItems) {
        this.itemList = newItems;
        notifyDataSetChanged();
    }
}
