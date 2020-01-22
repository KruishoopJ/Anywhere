package nl.johnbaaij.anywhere.main.nodes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractFragment;
import nl.johnbaaij.anywhere.addNodes.GatewayActivity;
import nl.johnbaaij.anywhere.db.NodeGroup;
import nl.johnbaaij.anywhere.db.NodeGroupDatabase;
import nl.johnbaaij.anywhere.main.nodes.NodeGroups.SelectedNodeGroup;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class NodeFragment extends AbstractFragment implements View.OnClickListener, NodeRecycleViewAdapter.OnGroupListener {

    private NodeViewModel nodeViewModel;

    //TODO change this with a NodeGroupsModel
    private ArrayList<String> mNodeGroupNames = new ArrayList<>();
    private ArrayList<Integer> mNodeGroupAmount = new ArrayList<>();
    private ArrayList<String> mNodeGroupIds = new ArrayList<>();
    private ArrayList<Boolean> mWarnings = new ArrayList<>();
    private ArrayList<Boolean> mBatteryErrors = new ArrayList<>();
    private ArrayList<Boolean> mWrenchErrors = new ArrayList<>();

    private FloatingActionButton mButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        nodeViewModel =
                ViewModelProviders.of(this).get(NodeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nodes, container, false);

        mButton = root.findViewById(R.id.addNodeButton);
        mButton.setOnClickListener(this);
        setToolbarTitle(getString(R.string.title_home));

        initRecyclerView(root);
        getData(getActivity());

        return root;
    }

    private void getData(Context context) {
        final NodeGroupDatabase appDb = NodeGroupDatabase.getInstance(context);

        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                final List<NodeGroup> nodeGroups = appDb.nodegroupDao().getNodeGroupList();
                if (nodeGroups.size() != 0) {
                    for (int i = 0; i < nodeGroups.size(); i++) {
                        mNodeGroupNames.add(nodeGroups.get(i).groupname);
                        mNodeGroupAmount.add(nodeGroups.get(i).amount);
                        mNodeGroupIds.add(nodeGroups.get(i).uid);
                        mWarnings.add(nodeGroups.get(i).generalWarning);
                        mBatteryErrors.add(nodeGroups.get(i).batteryWaring);
                        mWrenchErrors.add(nodeGroups.get(i).wrenchError);
                    }
                }
            }
        });

    }

    private void initRecyclerView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.node_recyclerView);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        NodeRecycleViewAdapter adapter = new NodeRecycleViewAdapter(mNodeGroupNames, mNodeGroupAmount, mBatteryErrors, getActivity(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new NodeDelete(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void openAddNodeActivity() {

        Intent intent = new Intent(getActivity(), GatewayActivity.class);
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
    public void onGroupClick(int position) {

        Intent intent = new Intent(getActivity(), SelectedNodeGroup.class);

        intent.putExtra("nodeName", mNodeGroupNames.get(position));
        intent.putExtra("id", mNodeGroupIds.get(position));

        startActivity(intent);

    }
}