package com.example.bookshelf; /* The Database */

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {DataEntities.class}, version = 1)
public abstract class TheDatabase extends RoomDatabase
{
    public abstract DocumentDao dpdfDao();
    private static volatile DataEntities INSTANCE;
    public static DataEntities getDatabase(final Context context)
    {
        if (INSTANCE == null) {
            synchronized (DataEntities.class) {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataEntities.class, "database-name").build();
                }
            }
        }
        return INSTANCE;
    }
}
