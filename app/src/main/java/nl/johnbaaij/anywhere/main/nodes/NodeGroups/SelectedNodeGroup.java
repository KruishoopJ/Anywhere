package nl.johnbaaij.anywhere.main.nodes.NodeGroups;

import android.os.Bundle;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;

public class SelectedNodeGroup extends AbstractToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_node_group);
    }
}
