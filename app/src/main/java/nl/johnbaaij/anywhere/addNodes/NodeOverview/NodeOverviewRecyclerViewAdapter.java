package nl.johnbaaij.anywhere.addNodes.NodeOverview;

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
import nl.johnbaaij.anywhere.main.settings.SettingsRecyclerViewAdaper;

public class NodeOverviewRecyclerViewAdapter extends RecyclerView.Adapter<NodeOverviewRecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> mNodeGroupNames = new ArrayList<>();
    private SettingsRecyclerViewAdaper.OnSettingListener mOnsettingListener;
    private Context mContext;

    public NodeOverviewRecyclerViewAdapter(ArrayList<String> nodeGroupNames, Context mContext ) {
        this.mNodeGroupNames = nodeGroupNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NodeOverviewRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_settings_item, parent, false);
        NodeOverviewRecyclerViewAdapter.ViewHolder holder = new NodeOverviewRecyclerViewAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull NodeOverviewRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.settingsLabel.setText(mNodeGroupNames.get(position));

    }

    @Override
    public int getItemCount() {
        return mNodeGroupNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView settingsLabel;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            settingsLabel = itemView.findViewById(R.id.settingslabel);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
