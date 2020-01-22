package nl.johnbaaij.anywhere.abstractClasses;

/*
Deze activity vervangt de standaard activity AppCompatActivity

Er word gebruik gemaakt van een custom toolbar die hierin wordt gedefineerd
Auteur: John Baaij
*/



import android.content.SharedPreferences;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import nl.johnbaaij.anywhere.R;

public abstract class AbstractToolbarActivity extends AppCompatActivity {

    Toolbar toolbar;



    protected void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    protected void addToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void enableBackButton(boolean isEnabled) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(isEnabled);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }



}
