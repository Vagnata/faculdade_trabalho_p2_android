package com.example.jonathas.room379aula;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import java.util.List;

@Database(entities = Anuncio.class, version=2)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDAO myDAO();

    public boolean buscaAnuncio(Anuncio anuncio) {
        List<Anuncio> anuncios = this.myDAO().listarAnuncios();

        for (Anuncio anunc: anuncios) {
            if (anunc.getId() == anuncio.getId()) {
                return true;
            }
        }

        return false;
    }
}
