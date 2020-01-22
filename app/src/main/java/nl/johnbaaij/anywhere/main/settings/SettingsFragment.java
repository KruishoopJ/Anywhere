/*

Hoofd settings pagina. Maakt gebruik van SettingsRecyclerview voor de content
*/


package nl.johnbaaij.anywhere.main.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.LoginActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractFragment;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class SettingsFragment extends AbstractFragment implements SettingsRecyclerViewAdaper.OnSettingListener {

    private SettingsViewModel settingsViewModel;
    private FirebaseAuth mAuth;


    private ArrayList<String> mSettingLabels = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        initNodeText();
        initRecyclerView(root);
        setToolbarTitle(getString(R.string.title_notifications));
        mAuth = FirebaseAuth.getInstance();
        return root;
    }


    //Names for the settings
    private void initNodeText() {
        mSettingLabels.add(getResources().getString(R.string.profile));
        mSettingLabels.add(getResources().getString(R.string.support));
        mSettingLabels.add(getResources().getString(R.string.termscons));
        mSettingLabels.add(getResources().getString(R.string.logout));

    }


    private void initRecyclerView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.settingsRecyclerView);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        SettingsRecyclerViewAdaper adapter = new SettingsRecyclerViewAdaper(mSettingLabels, getActivity(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onSettingClick(int position) {
        mSettingLabels.get(position);
        Log.d(TAG, "onSettingClick:" + position);
        changeActivity(position);


    }
    //change the activity based on the click position
    protected void changeActivity(int itemNumber) {

        Intent intent;

        switch (itemNumber) {
            case 0:
                intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getActivity(), SupportToolbarActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getActivity(), TermsConToolbarActivity.class);
                startActivity(intent);
                break;
            case 3:

                //this shows an alert for the Firebase logout.
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Logout");
                alert.setMessage("Do you want to logout?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAuth.signOut();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        getActivity().finish();

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