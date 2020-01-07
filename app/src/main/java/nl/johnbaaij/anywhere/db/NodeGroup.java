package nl.johnbaaij.anywhere.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "nodeGroup")
public class NodeGroup {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo (name = "groupname")
    public String groupname;
    @ColumnInfo (name = "amount")
    public int amount;
    @ColumnInfo (name = "lightConfig")
    public String lightConfig;

    public NodeGroup(String groupname, int amount, String lightConfig){
        this.groupname = groupname;
        this.amount = amount;
        this.lightConfig = lightConfig;
    }
}
