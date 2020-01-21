package nl.johnbaaij.anywhere.main.nodes.NodeGroups;

import android.content.Intent;
import android.os.Bundle;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;

public class SelectedNodeGroup extends AbstractToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_node_group);

        Intent i = getIntent();

        addToolbar();
        String name = (String) i.getSerializableExtra("nodeName");
        setToolbarTitle(name);

        enableBackButton(true);
    }
}
