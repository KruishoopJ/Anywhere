package nl.johnbaaij.anywhere.main.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;

public class SupportToolbarActivity extends AbstractToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        addToolbar();
        setToolbarTitle("support");
        enableBackButton(true);


        final FloatingActionButton button = findViewById(R.id.sendSupportMessage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Bedankt, we nemen zo snel mogelijk contact met je op",Toast.LENGTH_LONG).show();
            }
        });
    }


}
