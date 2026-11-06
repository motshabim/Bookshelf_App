package com.example.bookshelf; /* For the Database */

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
//dao:
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Entity(tableName = "documents")
public class DataEntities
{
    @PrimaryKey(autoGenerate = true)
    public long ID;
    public String title;
    @ColumnInfo(name = "file_path")
    public String filePath; //path to actual PDF
    @ColumnInfo(name = "cover_path")
    public String coverPath; //path to the saved cover thumbnail image
}

//Data Access Object (DAO)
@Dao
public interface DocumentDao {
    @Query("SELECT * FROM documents")
    List<DataEntities> getAllDocuments();
    @Insert
    long insertDocument(DataEntities document);
    @Delete
    long deleteDocument(DataEntities document);
}
