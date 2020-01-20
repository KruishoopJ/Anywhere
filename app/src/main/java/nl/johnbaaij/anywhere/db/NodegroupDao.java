package nl.johnbaaij.anywhere.db;

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


    @Insert
    void insertNodegroup(NodeGroup nodeGroup);

    @Update
    void updateNodeGroup(NodeGroup nodeGroup);

    @Delete
    void deleteNodegroup(NodeGroup nodeGroup);


}
