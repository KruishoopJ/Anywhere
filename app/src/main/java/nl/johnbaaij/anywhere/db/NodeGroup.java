/*

Deze class maakt een NOSQl database aan waarin de data wordt opgeslagen. Er is gebruikt gemaakt van Room uit AndroidX https://developer.android.com/jetpack/androidx/releases/room
Deze class is in feite een tabel

Auteur: John Baaij
*/



package nl.johnbaaij.anywhere.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nodeGroup")
public class NodeGroup {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "groupname")
    public String groupname;
    @ColumnInfo(name = "amount")
    public int amount;
    @ColumnInfo(name = "lightConfig")
    public String lightConfig;
    @ColumnInfo(name = "uid")
    public String uid;
    @ColumnInfo(name="batteryWarning")
    public boolean batteryWaring;
    @ColumnInfo (name="generalWarning")
    public boolean generalWarning;
    @ColumnInfo (name="wrenchError")
    public boolean wrenchError;


    public NodeGroup(String groupname, int amount, String lightConfig, String uid, boolean batteryWaring, boolean generalWarning, boolean wrenchError) {
        this.groupname = groupname;
        this.amount = amount;
        this.lightConfig = lightConfig;
        this.uid = uid;
        this.batteryWaring = batteryWaring;
        this.generalWarning = generalWarning;
        this.wrenchError = wrenchError;
    }
}
