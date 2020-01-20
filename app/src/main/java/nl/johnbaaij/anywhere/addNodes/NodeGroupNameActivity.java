package nl.johnbaaij.anywhere.addNodes;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractAddNodeActivity;
import nl.johnbaaij.anywhere.models.NodeGroups;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class NodeGroupNameActivity extends AbstractAddNodeActivity {

    String name;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_group_name);
        addToolbar();
        enableBackButton(true);

        Intent i = getIntent();
        nodeGroups = (NodeGroups) i.getSerializableExtra("mNodeGroups");

        button = findViewById(R.id.buttonProgress);
        editText = findViewById(R.id.NodeGoupNameInput);

        button.setText("Confirm");
        button.setEnabled(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        moveProgress(4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                openLightConfigActivity();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

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
