package nl.johnbaaij.anywhere.addNodes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractAddNodeActivity;
import nl.johnbaaij.anywhere.db.SaveToDatabase;
import nl.johnbaaij.anywhere.models.NodeGroups;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class LightConfigActivity extends AbstractAddNodeActivity {

    public static Handler handler = new Handler();

    SaveToDatabase saveToDatabase;
    DatabaseReference mDatabase;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth mAuth;
    FirebaseUser user;


    @Override
    protected void onStart() {
        super.onStart();
        moveProgress(5);
        setButtonCollor();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                handleData(false, false, false);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_config);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        saveToDatabase = new SaveToDatabase();
        Intent i = getIntent();
        nodeGroups = (NodeGroups) i.getSerializableExtra("mNodeGroups");
        textView = findViewById(R.id.ProgressText);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        addToolbar();
        enableBackButton(true);
        setToolbarTitle("Configure your lights");
        button = findViewById(R.id.buttonProgress);
        textView.setText("Set the type of light");

    }

    private void openMainActivity() {
        Log.d(TAG, "NodeGroupNameActivity called");
        Intent intent = new Intent(getApplicationContext(), MainToolbarActivity.class);
        Log.d(TAG, "created intent");
        finish();
        startActivity(intent);
        Log.d(TAG, "Started intent");
    }

    private void handleData(boolean batteryError, boolean warning, boolean wrenchError){
        String key = database.getReference("nodeGroups").push().getKey();
        //TODO placeholder light config
        nodeGroups.setLightConfig("PLACEHOLDER");
        nodeGroups.setHasBatteryError(batteryError);
        nodeGroups.setHasWarning(warning);
        nodeGroups.setHasWrenchError(wrenchError);
        mDatabase.child("nodegroups").child(user.getUid()).child(key).setValue(nodeGroups);
        saveToDatabase.saveToDB(nodeGroups, key);
        saveToDatabase.countDB(nodeGroups,key);
        openMainActivity();
        finish();

    }


}
