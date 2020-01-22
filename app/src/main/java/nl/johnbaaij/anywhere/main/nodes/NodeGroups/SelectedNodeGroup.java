package nl.johnbaaij.anywhere.main.nodes.NodeGroups;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.abstractClasses.AbstractToolbarActivity;
import nl.johnbaaij.anywhere.models.NodeGroups;



public class SelectedNodeGroup extends AbstractToolbarActivity {

    private DatabaseReference mDatabase;
    FirebaseUser user;
    private FirebaseAuth mAuth;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_node_group);
        mAuth = FirebaseAuth.getInstance();


        mDatabase = FirebaseDatabase.getInstance().getReference();
        user = mAuth.getCurrentUser();

        Intent i = getIntent();

        addToolbar();
        String name = (String) i.getSerializableExtra("nodeName");
        setToolbarTitle("Average of "+name);
        id = (String) i.getSerializableExtra("id");

        enableBackButton(true);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                showData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void showData(DataSnapshot dataSnapshot) {

        for (DataSnapshot ds : dataSnapshot.getChildren()){
            NodeGroups groups = new NodeGroups();
            groups.setName(ds.child(user.getUid()).child(id).getValue(NodeGroups.class).getName());
            groups.setScannedCodes(ds.child(user.getUid()).child(id).getValue(NodeGroups.class).getScannedCodes());

        }
    }
}
