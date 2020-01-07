package nl.johnbaaij.anywhere;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.addNodes.ProgressRecyclerViewAdapter;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

public class AddNodesActivity extends AbstractToolbarActivity {

    private ArrayList<String> mSettingLabels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_nodes);


    }


    private void initRecyclerView(View root){
        RecyclerView recyclerView = root.findViewById(R.id.settingsRecyclerView);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        ProgressRecyclerViewAdapter adapter = new ProgressRecyclerViewAdapter(mSettingLabels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
