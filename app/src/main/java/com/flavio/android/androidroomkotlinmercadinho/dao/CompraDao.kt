package com.flavio.android.androidroomkotlinmercadinho.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.flavio.android.androidroomkotlinmercadinho.model.Compra

@Dao
interface CompraDao {
    @Insert
    fun salvaCompra(compra : Compra)

    @Query("SELECT * FROM compra where id = :idBusca")
    fun consultaCompra(idBusca : Int): Compra

    @Query("SELECT * FROM compra")
    fun consultaTodasCompras(): List<Compra>

    @Delete
    fun deletaCompra(compra : Compra)
}