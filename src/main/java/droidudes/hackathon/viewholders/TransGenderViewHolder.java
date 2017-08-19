package droidudes.hackathon.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.TransGenderBO;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class TransGenderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnRecyclerItemClick onRecyclerItemClick;

    public TransGenderViewHolder(View itemView, OnRecyclerItemClick onRecyclerItemClick) {
        super(itemView);

        this.onRecyclerItemClick = onRecyclerItemClick;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (onRecyclerItemClick != null)
            onRecyclerItemClick.onItemClicked(v, getAdapterPosition());
    }

    public void bindData(TransGenderBO item){

    }
}
