package nl.johnbaaij.anywhere.addNodes;

/*
Deze activity toons de gateway fragment en vraagt om de camera toestemming


Auteur: John Baaij
*/

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractAddNodeActivity;


public class GatewayActivity extends AbstractAddNodeActivity {

    private ArrayList<String> mSettingLabels = new ArrayList<>();
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_nodes);

        addToolbar();
        enableBackButton(false);
        setToolbarTitle("Gateway check");

        textView = findViewById(R.id.ProgressText);
        textView.setText("Gateway connecting");


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (ContextCompat.checkSelfPermission(GatewayActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
            }
        }

        moveProgress(1);


    }

}
