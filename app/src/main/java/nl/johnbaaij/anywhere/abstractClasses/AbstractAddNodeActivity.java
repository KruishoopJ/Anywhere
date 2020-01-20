package nl.johnbaaij.anywhere.abstractClasses;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.models.NodeGroups;

public class AbstractAddNodeActivity extends AbstractToolbarActivity {


    protected Button button;
    protected TextView textView;
    protected ImageView progress1, progress2, progress3, progress4, progress5;
    protected NodeGroups nodeGroups;


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
