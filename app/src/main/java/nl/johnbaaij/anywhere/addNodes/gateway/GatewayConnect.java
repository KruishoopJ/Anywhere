package nl.johnbaaij.anywhere.addNodes.gateway;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.addNodes.ProgressRecyclerViewAdapter;
import nl.johnbaaij.anywhere.interfaces.InitRecyclerView;
import nl.johnbaaij.anywhere.main.settings.NotificationsViewModel;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

public class GatewayConnect extends Fragment implements InitRecyclerView {

    private GatewayConnectViewModel mViewModel;

    private ArrayList<String> mSettingLabels = new ArrayList<>();


    public static GatewayConnect newInstance() {
        return new GatewayConnect();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel =
                ViewModelProviders.of(this).get(GatewayConnectViewModel.class);

        View root = inflater.inflate(R.layout.gateway_connect_fragment, container, false);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        initNodeText();
        initRecyclerView(root);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GatewayConnectViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
     public void initRecyclerView(View root) {

        RecyclerView recyclerView = root.findViewById(R.id.ProgressBarArea);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        ProgressRecyclerViewAdapter adapter = new ProgressRecyclerViewAdapter(mSettingLabels, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void initNodeText(){
        mSettingLabels.add(getResources().getString(R.string.profile));

    }

}
