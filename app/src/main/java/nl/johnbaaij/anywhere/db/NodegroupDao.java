package nl.johnbaaij.anywhere.db;

/*

Deze class bevat queries die met AndroidX Room kunnen worden uitgevoerd in de NoSQL database https://developer.android.com/jetpack/androidx/releases/room
Auteur: John Baaij
*/


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface NodegroupDao {

    @Query("Select * From nodeGroup")
    List<NodeGroup> getNodeGroupList();

    @Query("SELECT COUNT(id) FROM nodegroup")
    int getCount();

    @Insert
    void insertNodegroup(NodeGroup nodeGroup);

    @Update
    void updateNodeGroup(NodeGroup nodeGroup);

    @Delete
    void deleteNodegroup(NodeGroup nodeGroup);


}
