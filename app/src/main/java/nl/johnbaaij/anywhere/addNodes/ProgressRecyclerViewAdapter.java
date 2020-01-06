package nl.johnbaaij.anywhere.addNodes;


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

public class ProgressRecyclerViewAdapter extends RecyclerView.Adapter<ProgressRecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> mButtonText = new ArrayList<>();
    private ArrayList<String> mProgressLabel = new ArrayList<>();
    private Context mContext;

    public ProgressRecyclerViewAdapter(ArrayList<String> mNodeGroupNames, Context mContext) {
        this.mButtonText = mNodeGroupNames;
        this.mProgressLabel = mProgressLabel;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_add_node_progress, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // holder.nodeGroupName.setText(mButtonText.get(position));

    }

    @Override
    public int getItemCount() {
        return mButtonText.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //TextView nodeGroupName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // nodeGroupName = itemView.findViewById(R.id.nodeGroupName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }



}
