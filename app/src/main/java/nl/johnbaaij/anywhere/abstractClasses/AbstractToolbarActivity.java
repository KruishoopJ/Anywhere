package nl.johnbaaij.anywhere.abstractClasses;


import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import nl.johnbaaij.anywhere.R;

public abstract class AbstractToolbarActivity extends AppCompatActivity {

    Toolbar toolbar;
    protected SharedPreferences sharedPreferences;

    public AbstractToolbarActivity(){

    }

    protected void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    protected void addToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void enableBackButton (boolean isEnabled){
        getSupportActionBar().setDisplayHomeAsUpEnabled(isEnabled);
    }


}
