package nl.johnbaaij.anywhere.db;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.models.NodeGroups;


public class SaveToDatabase {



    public void saveToDB(NodeGroups groups) {

        Context applicationContext = MainToolbarActivity.getContextOfApplication();


        final NodeGroupDatabase appDb = NodeGroupDatabase.getInstance(applicationContext);
        final NodeGroup nodeGroup = new NodeGroup(groups.getName(), groups.getScannedCodes().size(), groups.getLightConfig());
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDb.nodegroupDao().insertNodegroup(nodeGroup);
            }
        });
    }
}
