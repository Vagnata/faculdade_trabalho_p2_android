package com.example.jonathas.room379aula;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

@Database(entities = Anuncio.class, version=2)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDAO myDAO();
}
