package nl.johnbaaij.anywhere.main.settings;


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
    private FirebaseAuth.AuthStateListener  authStateListener;

    String name, phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        addToolbar();
        setToolbarTitle("Profile");
        enableBackButton(true);





        nameTextView = (TextView) findViewById(R.id.nameTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        phoneTextView = (TextView) findViewById(R.id.phoneTextView);

        firebaseAuth = FirebaseAuth.getInstance();

         FirebaseUser user  = firebaseAuth.getCurrentUser();

        checkUserInfo(user);

        name = "Test User";



        nameTextView.setText(name);
        emailTextView.setText("E-mail : " + user.getEmail());
        phoneTextView.setText(phoneNumber);



    }

    private void checkUserInfo(FirebaseUser user){
        String i = user.getDisplayName();
        String j = user.getPhoneNumber();

        if (i == "" | i == null){
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName("Test user")
                    .build();
        }
    }


}
