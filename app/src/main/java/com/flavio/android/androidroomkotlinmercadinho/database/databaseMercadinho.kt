package com.flavio.android.androidroomkotlinmercadinho.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flavio.android.androidroomkotlinmercadinho.dao.CompraDao
import com.flavio.android.androidroomkotlinmercadinho.dao.CompraProdutoDao
import com.flavio.android.androidroomkotlinmercadinho.dao.ProdutoDao
import com.flavio.android.androidroomkotlinmercadinho.model.Compra
import com.flavio.android.androidroomkotlinmercadinho.model.CompraProduto
import com.flavio.android.androidroomkotlinmercadinho.model.Produto

@Database(entities = [Compra::class,Produto::class,CompraProduto::class],version = 1,exportSchema = false)
abstract class DatabaseMercadinho : RoomDatabase() {
    abstract fun getCompraDao(): CompraDao
    abstract fun getProdutoDao(): ProdutoDao
    abstract fun getCompraProdutoDao() : CompraProdutoDao
}