package nl.johnbaaij.anywhere.db;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.models.NodeGroups;


public class SaveToDatabase {


    public void saveToDB(NodeGroups groups, String uid) {

        Context applicationContext = MainToolbarActivity.getContextOfApplication();

        final NodeGroupDatabase appDb = NodeGroupDatabase.getInstance(applicationContext);
        final NodeGroup nodeGroup = new NodeGroup(groups.getName(), groups.getScannedCodes().size(), groups.getLightConfig(), uid, groups.isHasBatteryError(), groups.isHasWarning(), groups.isHasWrenchError());
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDb.nodegroupDao().insertNodegroup(nodeGroup);
            }
        });
    }

    public void countDB(NodeGroups groups, String uid){

        Context applicationContext = MainToolbarActivity.getContextOfApplication();
        final NodeGroup nodeGroup = new NodeGroup(groups.getName()+ "  WithError", groups.getScannedCodes().size(), groups.getLightConfig(), uid, true, groups.isHasWarning(), groups.isHasWrenchError());
        final NodeGroupDatabase appDb = NodeGroupDatabase.getInstance(applicationContext);
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
               final int amount =appDb.nodegroupDao().getCount();
               if (amount ==0){
                   Executor myExecutor = Executors.newSingleThreadExecutor();
                   myExecutor.execute(new Runnable() {
                       @Override
                       public void run() {
                           appDb.nodegroupDao().insertNodegroup(nodeGroup);
                       }
                   });
               }
            }
        });
    }
}
