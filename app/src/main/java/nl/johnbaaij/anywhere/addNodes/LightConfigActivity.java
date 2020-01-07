package nl.johnbaaij.anywhere.addNodes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.db.SQLiteDBHelper;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LightConfigActivity extends AbstractToolbarActivity {

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
        SQLiteDatabase database = new SQLiteDBHelper(this).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.NODE_GROUP_NAME, "test");
        values.put(SQLiteDBHelper.NODE_AMOUNT,Math.random());
        values.put(SQLiteDBHelper.NODE_LIGHT_CONFIG, "LED licht ofzo");
        long newRowId = database.insert(SQLiteDBHelper.NODE_GROUP_TABLE, null, values);

    }

}
