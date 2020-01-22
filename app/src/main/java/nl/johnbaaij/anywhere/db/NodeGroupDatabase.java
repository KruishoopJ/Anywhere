package nl.johnbaaij.anywhere.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = NodeGroup.class, exportSchema = false, version = 4)
public abstract class NodeGroupDatabase extends RoomDatabase {

    private static final String DB_NAME = "node_db";
    private static NodeGroupDatabase instance;
    public static synchronized NodeGroupDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NodeGroupDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
    public abstract NodegroupDao nodegroupDao();
}
