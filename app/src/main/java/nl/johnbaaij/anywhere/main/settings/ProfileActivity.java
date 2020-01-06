package nl.johnbaaij.anywhere.main.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import nl.johnbaaij.anywhere.R;

public class ProfileActivity extends AppCompatActivity {



    TextView nameTextView;
    TextView emailTextView;
    TextView phoneTextView;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener  authStateListener;

    public ProfileActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        nameTextView = (TextView) findViewById(R.id.nameTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        phoneTextView = (TextView) findViewById(R.id.phoneTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        final FirebaseUser user  = firebaseAuth.getCurrentUser();

        nameTextView.setText(user.getDisplayName());
        emailTextView.setText("E-mail : " + user.getEmail());
        phoneTextView.setText(user.getPhoneNumber());



    }
}
