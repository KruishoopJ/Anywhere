package nl.johnbaaij.anywhere.main.settings;

/*

Dit laat het profiel zien vanuit Firebase. Op dit moment is het niet mogelijk om de gegevens aan te passen*/


import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;

public class ProfileActivity extends AbstractToolbarActivity {


    TextView nameTextView;
    TextView emailTextView;
    TextView phoneTextView;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    String name, phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        addToolbar();
        setToolbarTitle("Profile");
        enableBackButton(true);


        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneTextView = findViewById(R.id.phoneTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        checkUserInfo(user);

        name = "Test User";


        nameTextView.setText(name);
        emailTextView.setText("E-mail : " + user.getEmail());
        phoneTextView.setText(phoneNumber);


    }

    //TODO replace with quantified system
    //email accounts don't contain a name. This adds a fake name
    private void checkUserInfo(FirebaseUser user) {
        String i = user.getDisplayName();
        String j = user.getPhoneNumber();

        if (i == "" | i == null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName("Test user")
                    .build();
        }
    }


}
