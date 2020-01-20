package nl.johnbaaij.anywhere.addNodes;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractAddNodeActivity;
import nl.johnbaaij.anywhere.addNodes.NodeOverview.NodeOverviewRecyclerViewAdapter;
import nl.johnbaaij.anywhere.main.settings.SettingsRecyclerViewAdaper;
import nl.johnbaaij.anywhere.models.NodeGroups;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class NodeOverviewActivity extends AbstractAddNodeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_overview);
        addToolbar();
        enableBackButton(true);
        setToolbarTitle("Node Overview");
        Intent i = getIntent();
        nodeGroups = (NodeGroups)i.getSerializableExtra("mNodeGroups");
        initRecyclerView();




        button = findViewById(R.id.buttonProgress);

        // Init textview so the code can overwrite
        textView = (TextView) findViewById(R.id.ProgressText);

        // Set textview to scan node
        textView.setText("Scan node");

    }





    @Override
    protected void onStart() {
        super.onStart();
        moveProgress(3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLightConfigActivity();
            }
        });

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = this.findViewById(R.id.node_overview);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getApplicationContext(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        NodeOverviewRecyclerViewAdapter adapter = new NodeOverviewRecyclerViewAdapter(nodeGroups.getScannedCodes(),getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void openLightConfigActivity() {

        Log.d(TAG, "NodeGroupNameActivity called");
        Intent intent = new Intent(getApplicationContext(), NodeGroupNameActivity.class);

        intent.putExtra("mNodeGroups", nodeGroups);
        Log.d(TAG, "created intent");
        startActivity(intent);
        Log.d(TAG, "Started intent");
    }
}
