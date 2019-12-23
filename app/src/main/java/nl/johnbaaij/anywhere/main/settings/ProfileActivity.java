package nl.johnbaaij.anywhere.main.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import nl.johnbaaij.anywhere.R;

public class ProfileActivity extends AppCompatActivity {

    public ProfileActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
