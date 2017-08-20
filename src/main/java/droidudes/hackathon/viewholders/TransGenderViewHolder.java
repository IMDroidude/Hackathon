package droidudes.hackathon.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import droidudes.hackathon.R;
import droidudes.hackathon.interfaces.OnRecyclerItemClick;
import droidudes.hackathon.models.TransGenderBO;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class TransGenderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnRecyclerItemClick onRecyclerItemClick;
    private TextView nameTv,ageTv,skillTv;

    public TransGenderViewHolder(View itemView, OnRecyclerItemClick onRecyclerItemClick) {
        super(itemView);

        this.onRecyclerItemClick = onRecyclerItemClick;

        nameTv = (TextView) itemView.findViewById(R.id.tv_name);
        ageTv = (TextView)  itemView.findViewById(R.id.tv_age);
        skillTv = (TextView) itemView.findViewById(R.id.tv_skils);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (onRecyclerItemClick != null)
            onRecyclerItemClick.onItemClicked(v, getAdapterPosition());
    }

    public void bindData(TransGenderBO item){
        if(item != null){
            nameTv.setText(item.getName());
            ageTv.setText(item.getAge() + "");
            skillTv.setText(item.getSkills());
        }
    }
}
