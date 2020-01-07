package nl.johnbaaij.anywhere.addNodes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class NodeGroupNameActivity extends AbstractToolbarActivity {



    //TODO replace with real name that needs to be passed to the activity
    String name = "demoName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_group_name);
        addToolbar();
        enableBackButton(true);

        final Button button = findViewById(R.id.buttonProgress);



        button.setText("Confirm");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLightConfigActivity();

            }
        });
    }

    private void openLightConfigActivity() {

        Log.d(TAG, "NodeGroupNameActivity called");
        Intent intent = new Intent(getApplicationContext(), LightConfigActivity.class);
        //TODO pass real name from this class to LightConfigActivity
        intent.putExtra("groupName", name);
        Log.d(TAG, "created intent");
        startActivity(intent);
        Log.d(TAG, "Started intent");
    }



}
