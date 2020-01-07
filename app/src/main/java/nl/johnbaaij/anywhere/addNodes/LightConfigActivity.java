package nl.johnbaaij.anywhere.addNodes;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.db.NodeGroup;
import nl.johnbaaij.anywhere.db.NodeGroupDatabase;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LightConfigActivity extends AbstractToolbarActivity {

    public static Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_config);


        addToolbar();
        enableBackButton(true);

        final Button button = findViewById(R.id.buttonProgress);

        button.setText("Confirm");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
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


    private void saveToDB() {
        final NodeGroupDatabase appDb = NodeGroupDatabase.getInstance(getApplication());
        final NodeGroup nodeGroup = new NodeGroup("Tomaten", 25, "led");
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDb.nodegroupDao().insertNodegroup(nodeGroup);
            }
        });



    }





}
