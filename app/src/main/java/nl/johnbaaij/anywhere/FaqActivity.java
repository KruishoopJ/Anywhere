package nl.johnbaaij.anywhere;


import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.addNodes.NodeOverview.NodeOverviewRecyclerViewAdapter;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

public class FaqActivity extends AbstractToolbarActivity {


    private ArrayList<String> faq = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        addToolbar();
        enableBackButton(true);
        setToolbarTitle("FAQ");
        fillList();
        initRecyclerView();

    }

    private void fillList(){
        faq.add("Wat is een gateway");
    }


    private void initRecyclerView() {
        RecyclerView recyclerView = this.findViewById(R.id.faq_recyclerView);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getApplicationContext(), HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        NodeOverviewRecyclerViewAdapter adapter = new NodeOverviewRecyclerViewAdapter(faq, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
