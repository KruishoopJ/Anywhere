package nl.johnbaaij.anywhere.addNodes;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.db.SaveToDatabase;
import nl.johnbaaij.anywhere.models.NodeGroups;


import static androidx.constraintlayout.widget.Constraints.TAG;

public class LightConfigActivity extends AbstractToolbarActivity {

    public static Handler handler = new Handler();

    SaveToDatabase saveToDatabase;
    NodeGroups nodeGroups;
    DatabaseReference mDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_config);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        saveToDatabase = new SaveToDatabase();
        Intent i = getIntent();
        nodeGroups = (NodeGroups)i.getSerializableExtra("mNodeGroups");

        addToolbar();
        enableBackButton(true);

        final Button button = findViewById(R.id.buttonProgress);

        button.setText("Confirm");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO placeholder light config
                nodeGroups.setLightConfig("PLACEHOLDER");
                mDatabase.child("users").child("1").setValue(nodeGroups);
                saveToDatabase.saveToDB(nodeGroups);
                openMainActivity();

            }
        });

    }

    private void openMainActivity() {


        Log.d(TAG, "NodeGroupNameActivity called");
        Intent intent = new Intent(getApplicationContext(), MainToolbarActivity.class);
        Log.d(TAG, "created intent");
        startActivity(intent);
        Log.d(TAG, "Started intent");
    }












}
