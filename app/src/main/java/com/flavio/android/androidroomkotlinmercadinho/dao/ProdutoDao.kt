package com.flavio.android.androidroomkotlinmercadinho.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.flavio.android.androidroomkotlinmercadinho.model.Produto

@Dao
interface ProdutoDao {
    @Insert
    fun salvaProduto(produto : Produto)

    @Query("SELECT * FROM produto where id = :idBusca")
    fun consultaProduto(idBusca : Int): Produto

    @Query("SELECT * FROM produto")
    fun consultaTodasProdutos(): List<Produto>

    @Delete
    fun deletaProduto(produto : Produto)
}