package com.example.jonathas.room379aula;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDAO {

    @Insert
    public void inserirAnuncio(Anuncio anuncio);

    @Query("select *from anuncios")
    public List<Anuncio> listarAnuncios();

    @Delete
    public void deletarAnuncio(Anuncio anuncio);

    @Update
    public void atualizarAnuncio(Anuncio anuncio);
}
