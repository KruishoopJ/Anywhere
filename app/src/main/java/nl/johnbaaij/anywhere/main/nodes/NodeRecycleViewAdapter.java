package nl.johnbaaij.anywhere.main.nodes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.R;

public class NodeRecycleViewAdapter extends RecyclerView.Adapter<NodeRecycleViewAdapter.ViewHolder> {


    private ArrayList<String> mNodeGroupNames = new ArrayList<>();
    private Context mContext;

    public NodeRecycleViewAdapter(ArrayList<String> mNodeGroupNames, Context mContext) {
        this.mNodeGroupNames = mNodeGroupNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_node_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nodeGroupName.setText(mNodeGroupNames.get(position));

    }

    @Override
    public int getItemCount() {
        return mNodeGroupNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nodeGroupName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nodeGroupName = itemView.findViewById(R.id.nodeGroupName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }



}
