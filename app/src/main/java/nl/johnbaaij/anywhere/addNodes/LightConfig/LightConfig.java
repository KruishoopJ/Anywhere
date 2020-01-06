package nl.johnbaaij.anywhere.addNodes.LightConfig;

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

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

public class LightConfig extends Fragment implements InitRecyclerView {

    private LightConfigViewModel mViewModel;

    private ArrayList<String> mSettingLabels = new ArrayList<>();


    public static LightConfig newInstance() {
        return new LightConfig();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.light_config_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LightConfigViewModel.class);
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
}
