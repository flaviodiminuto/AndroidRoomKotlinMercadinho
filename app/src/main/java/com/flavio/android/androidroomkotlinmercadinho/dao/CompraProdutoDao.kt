package com.flavio.android.androidroomkotlinmercadinho.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.flavio.android.androidroomkotlinmercadinho.model.Compra
import com.flavio.android.androidroomkotlinmercadinho.model.CompraProduto
import com.flavio.android.androidroomkotlinmercadinho.model.Produto

@Dao
interface CompraProdutoDao {


    @Insert
    fun salvarCompraProduto(compraProduto: CompraProduto)

    @Query("SELECT pc.* FROM compraproduto pc INNER JOIN produto p on pc.produto_id= p.id  where pc.compra_id = :idBusca")
    fun consultaCompraProduto(idBusca  : Int): List<CompraProduto>

    @Query("SELECT * FROM compraproduto")
    fun consultarTodosCompraProduto() : List<CompraProduto>

    @Delete
    fun deletaCompraProduto(compraProduto: CompraProduto)

}