package nl.johnbaaij.anywhere.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "node_database";
    public static final String NODE_GROUP_COLUMN_ID = "_id";
    public static final String NODE_GROUP_TABLE = "person";
    public static final String NODE_AMOUNT = "amount";
    public static final String NODE_GROUP_NAME = "groupName";
    public static final String NODE_LIGHT_CONFIG = "lightConfig";


    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + NODE_GROUP_TABLE + " (" +
                NODE_GROUP_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NODE_GROUP_NAME + " TEXT, " +
                NODE_AMOUNT + " INT , " +
                NODE_LIGHT_CONFIG + " TEXT" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NODE_GROUP_TABLE);
        onCreate(db);

    }
}
