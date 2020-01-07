package nl.johnbaaij.anywhere.main.settings;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;

public class TermsConToolbarActivity extends AbstractToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_con);


        //add toolbar from super class
        addToolbar();

        //set the title of the toolbar
        setToolbarTitle("Terms and Conditions");

        //add a backbutton to the application
        enableBackButton(true);

        WebView webView = (WebView) findViewById(R.id.termsConsWebview);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://www.apple.com/legal/internet-services/itunes/us/terms.html");

    }
}
