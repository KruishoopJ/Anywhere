package nl.johnbaaij.anywhere.main.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.main.nodes.NodeRecycleViewAdapter;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class NotificationsFragment extends Fragment implements SettingsRecyclerViewAdaper.OnSettingListener {

    private NotificationsViewModel notificationsViewModel;

    private ArrayList<String> mSettingLabels = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        initNodeText();
        initRecyclerView(root);

        return root;
    }

    private void initNodeText(){
        mSettingLabels.add(getResources().getString(R.string.profile));
        mSettingLabels.add(getResources().getString(R.string.support));
        mSettingLabels.add(getResources().getString(R.string.termscons));
        mSettingLabels.add(getResources().getString(R.string.logout));

    }


    private void initRecyclerView(View root){
        RecyclerView recyclerView = root.findViewById(R.id.settingsRecyclerView);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        SettingsRecyclerViewAdaper adapter = new SettingsRecyclerViewAdaper(mSettingLabels, getActivity(),  this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onSettingClick(int position) {
        mSettingLabels.get(position);
        Log.d(TAG, "onSettingClick:" + position);
        changeActivity(position);


    }

    protected void changeActivity(int itemNumber){

        Intent intent;

        switch (itemNumber){
            case 0:
                intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getActivity(), SupportActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getActivity(), TermsConActivity.class);
                startActivity(intent);
                break;
            case 3:
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Logout");
                alert.setMessage("Do you want to logout?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Log.d(TAG, "onClick: Implement logout function");

                    }
                });

                alert.setNegativeButton("No", null
                );

                alert.create().show();

                break;
            default:
                break;

        }


    }
}