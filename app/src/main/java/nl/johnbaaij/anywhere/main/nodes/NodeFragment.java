package nl.johnbaaij.anywhere.main.nodes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.AddNodesActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.interfaces.initToolbar;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class NodeFragment extends Fragment implements View.OnClickListener, initToolbar {

    private NodeViewModel nodeViewModel;

    private ArrayList<String> mNodeGroupNames = new ArrayList<>();

    private Button mButton;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        nodeViewModel =
                ViewModelProviders.of(this).get(NodeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nodes, container, false);

        mButton = root.findViewById(R.id.addNodeButton);
        mButton.setOnClickListener(this);
        setToolbarTitle(getString(R.string.title_home));


        initNodeText();
        initRecyclerView(root);


        return root;
    }

    private void initNodeText(){
        mNodeGroupNames.add("Hallo");
        mNodeGroupNames.add("Hallo2");
    }

    private void initRecyclerView(View root){
        RecyclerView recyclerView = root.findViewById(R.id.node_recyclerView);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        NodeRecycleViewAdapter adapter = new NodeRecycleViewAdapter(mNodeGroupNames, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void openAddNodeActivity(){

       Intent intent = new Intent(getActivity(), AddNodesActivity.class);
       startActivity(intent);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addNodeButton:
                // Do something 

                Log.d(TAG, "onClick: dit werkt nu ");
                openAddNodeActivity();
        }

    }

    @Override
    public void setToolbarTitle(String title) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }
}