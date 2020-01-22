/*

Dit is de recyclerview voor de settings. Dit is een simpele list die doorverwijst naar de bijbehorende activity

*/




package nl.johnbaaij.anywhere.main.settings;

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

public class SettingsRecyclerViewAdaper extends RecyclerView.Adapter<SettingsRecyclerViewAdaper.ViewHolder> {

    //labels for the settings
    private ArrayList<String> mNodeGroupNames = new ArrayList<>();
    private OnSettingListener mOnsettingListener;
    private Context mContext;

    public SettingsRecyclerViewAdaper(ArrayList<String> nodeGroupNames, Context mContext, OnSettingListener onSettingListener) {
        this.mNodeGroupNames = nodeGroupNames;
        this.mContext = mContext;
        this.mOnsettingListener = onSettingListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_settings_item, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnsettingListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.settingsLabel.setText(mNodeGroupNames.get(position));

    }

    @Override
    public int getItemCount() {
        return mNodeGroupNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView settingsLabel;
        RelativeLayout parentLayout;

        OnSettingListener onSettingListener;

        public ViewHolder(@NonNull View itemView, OnSettingListener onSettingListener) {
            super(itemView);
            settingsLabel = itemView.findViewById(R.id.settingslabel);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            onSettingListener = mOnsettingListener;


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnsettingListener.onSettingClick(getAdapterPosition());

        }
    }

    public interface OnSettingListener {
        void onSettingClick(int position);
    }


}
