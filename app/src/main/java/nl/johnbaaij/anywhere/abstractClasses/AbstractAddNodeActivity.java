package nl.johnbaaij.anywhere.abstractClasses;

/*
Dit fragment vervangt AbstractToolbarActivity en wordt gebruikt in het installatie process. Er worden hierin functies en objecten
gedefineerd die in deze classes herhaaldelijk voorkomen. zoals het terug menu

Er word gebruik gemaakt van een custom toolbar die hierin wordt gedefineerd
Auteur: John Baaij
*/

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.FaqActivity;
import nl.johnbaaij.anywhere.LoginActivity;
import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.models.NodeGroups;

public class AbstractAddNodeActivity extends AbstractToolbarActivity {


    protected Button button;
    protected TextView textView;
    protected ImageView progress1, progress2, progress3, progress4, progress5;
    protected NodeGroups nodeGroups;


    protected void setButtonCollor(){
        button.setCompoundDrawablesWithIntrinsicBounds( null, null, this.getDrawable(R.drawable.ic_arrow_forward_white_24dp) ,null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.top_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.navigation_faq:
                openFAQ();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openFAQ() {
        Intent intent = new Intent(AbstractAddNodeActivity.this, FaqActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        // your code.

        //this shows an alert to lose your progress
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure ?");
        alert.setMessage("You will loose all your progress");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(AbstractAddNodeActivity.this, MainToolbarActivity.class);
                startActivity(intent);
                finish();
            }
        });

        alert.setNegativeButton("No", null
        );

        alert.create().show();
    }

    public NodeGroups createGroup(String name, String lightConfig, ArrayList<String> list, boolean light, boolean warning, boolean battery ){
        NodeGroups group = new NodeGroups(name, lightConfig, list,light, warning, battery );
        return group;
    }

    //Dit is voor de progressbar die wordt gevuld.
    public void moveProgress(int screen) {

        progress1 = findViewById(R.id.progress_dot3);
        progress2 = findViewById(R.id.progress_dot2);
        progress3 = findViewById(R.id.progress_dot1);
        progress4 = findViewById(R.id.progress_dot4);
        progress5 = findViewById(R.id.progress_dot5);

        switch (screen) {
            case 1:
                progress1.setBackgroundResource(R.drawable.drawable_circle_white);
                break;
            case 2:
                progress1.setBackgroundResource(R.drawable.drawable_circle_white);
                progress2.setBackgroundResource(R.drawable.drawable_circle_white);
                break;
            case 3:
                progress1.setBackgroundResource(R.drawable.drawable_circle_white);
                progress2.setBackgroundResource(R.drawable.drawable_circle_white);
                progress3.setBackgroundResource(R.drawable.drawable_circle_white);
                break;
            case 4:
                progress1.setBackgroundResource(R.drawable.drawable_circle_white);
                progress2.setBackgroundResource(R.drawable.drawable_circle_white);
                progress3.setBackgroundResource(R.drawable.drawable_circle_white);
                progress4.setBackgroundResource(R.drawable.drawable_circle_white);
                break;
            case 5:
                progress1.setBackgroundResource(R.drawable.drawable_circle_white);
                progress2.setBackgroundResource(R.drawable.drawable_circle_white);
                progress3.setBackgroundResource(R.drawable.drawable_circle_white);
                progress4.setBackgroundResource(R.drawable.drawable_circle_white);
                progress5.setBackgroundResource(R.drawable.drawable_circle_white);
                break;
        }


    }
}
