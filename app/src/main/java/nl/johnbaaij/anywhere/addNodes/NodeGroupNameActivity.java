package nl.johnbaaij.anywhere.addNodes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.models.NodeGroups;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class NodeGroupNameActivity extends AbstractToolbarActivity {

    NodeGroups nodeGroups;
    String name;



    //TODO replace with real name that needs to be passed to the activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_group_name);
        addToolbar();
        enableBackButton(true);
        //sharedPreferences = getSharedPreferences("addNodes", getApplication().MODE_PRIVATE);

        Intent i = getIntent();
        nodeGroups = (NodeGroups)i.getSerializableExtra("mNodeGroups");

        final Button button = findViewById(R.id.buttonProgress);
        final EditText editText = findViewById(R.id.NodeGoupNameInput);

        button.setText("Confirm");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();


                //sharedPreferences.edit().putString("nodeName", name).apply();
                openLightConfigActivity();
            }
        });
    }

    private void openLightConfigActivity() {

        Log.d(TAG, "NodeGroupNameActivity called");
        Intent intent = new Intent(getApplicationContext(), LightConfigActivity.class);

        nodeGroups.setName(name);
        //TODO pass real name from this class to LightConfigActivity
        intent.putExtra("mNodeGroups", nodeGroups);
        Log.d(TAG, "created intent");
        Log.d(TAG, nodeGroups.getName());
        startActivity(intent);
        Log.d(TAG, "Started intent");
    }



}
