package nl.johnbaaij.anywhere.main.nodes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.R;

public class NodeRecycleViewAdapter extends RecyclerView.Adapter<NodeRecycleViewAdapter.ViewHolder> {


    private ArrayList<String> mNodeGroupNames = new ArrayList<>();
    private ArrayList<Integer> mNodeGroupAmount = new ArrayList<>();
    private ArrayList<Boolean> mBatteryErrors = new ArrayList<>();
    private Context mContext;
    private OnGroupListener mOngroupListener;

    public NodeRecycleViewAdapter(ArrayList<String> mNodeGroupNames, ArrayList<Integer> mNodeGroupAmount, ArrayList<Boolean> mBatteryErrors, Context mContext, OnGroupListener onGroupListener) {
        this.mNodeGroupNames = mNodeGroupNames;
        this.mNodeGroupAmount = mNodeGroupAmount;
        this.mContext = mContext;
        this.mOngroupListener = onGroupListener;
        this.mBatteryErrors = mBatteryErrors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_node_item, parent, false);
        ViewHolder holder = new ViewHolder(view, mOngroupListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nodeGroupName.setText(mNodeGroupNames.get(position));
        holder.nodeAmount.setText(mNodeGroupAmount.get(position).toString());

        if (mBatteryErrors.get(position)){
            holder.errorView.setBackground(holder.itemView.getResources().getDrawable(R.drawable.ic_battery_alert_black_24dp));
        }

    }

    @Override
    public int getItemCount() {
        return mNodeGroupNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nodeGroupName, nodeAmount;
        RelativeLayout parentLayout;
        OnGroupListener onGroupListener;
        ImageView errorView;

        public ViewHolder(@NonNull View itemView, OnGroupListener onGroupListener) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            nodeGroupName = itemView.findViewById(R.id.nodeGroupName);
            nodeAmount = itemView.findViewById(R.id.nodeAmount);
            errorView = itemView.findViewById(R.id.nodeError);
            this.onGroupListener = onGroupListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onGroupListener.onGroupClick(getAdapterPosition());

        }
    }

    public void deleteItem(int position) {
        //mRecentlyDeletedItem = mListItems.get(position);
        //mRecentlyDeletedItemPosition = position;
        mNodeGroupNames.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnGroupListener {
        void onGroupClick(int position);
    }


}
