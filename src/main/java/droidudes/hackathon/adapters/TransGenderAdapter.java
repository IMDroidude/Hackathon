package droidudes.hackathon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import droidudes.hackathon.R;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.TransGenderBO;
import droidudes.hackathon.viewholders.TransGenderViewHolder;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class TransGenderAdapter extends RecyclerView.Adapter<TransGenderViewHolder> {

    private Context mContext;
    private List<TransGenderBO> itemList;
    private OnRecyclerItemClick onRecyclerItemClick;

    public TransGenderAdapter(Context mContext, List<TransGenderBO> itemList, OnRecyclerItemClick onRecyclerItemClick) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.onRecyclerItemClick = onRecyclerItemClick;
    }

    @Override
    public TransGenderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.item_trans_gender_list,
                parent, false);
        return new TransGenderViewHolder(mView, onRecyclerItemClick);
    }

    @Override
    public void onBindViewHolder(TransGenderViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(List<TransGenderBO> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }
}
