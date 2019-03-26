package com.flavio.android.androidroomkotlinmercadinho.database

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.flavio.android.androidroomkotlinmercadinho.dao.CompraDao
import com.flavio.android.androidroomkotlinmercadinho.dao.CompraProdutoDao
import com.flavio.android.androidroomkotlinmercadinho.dao.ProdutoDao
import com.flavio.android.androidroomkotlinmercadinho.model.Compra
import com.flavio.android.androidroomkotlinmercadinho.model.CompraProduto
import com.flavio.android.androidroomkotlinmercadinho.model.Produto


@Database(entities = [Compra::class,Produto::class,CompraProduto::class],version = 4,exportSchema = false)
abstract class DatabaseMercadinho : RoomDatabase() {
    abstract fun getCompraDao(): CompraDao
    abstract fun getProdutoDao(): ProdutoDao
    abstract fun getCompraProdutoDao() : CompraProdutoDao
companion object {
    val MICRATION_1_2 = object : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE produto ADD COLUMN categoria TEXT")
        }

    }
    val MIGRATION_2_3 = object :Migration(2,3){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE produto ADD COLUMN oferta TEXT")
        }

    }

    val MIGRATION_3_4 = object : Migration(3,4){
        override fun migrate(database: SupportSQLiteDatabase) {
            // criar nova tabela com a estrutura que desejamos
            database.execSQL("CREATE TABLE IF NOT EXISTS `nova` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `valor` REAL NOT NULL, `categoria` TEXT)")
            // copiar os dados da tabela antiga para a nova tabela
            database.execSQL("INSERT INTO nova('id','nome','valor','categoria') SELECT 'id','nome','valor','categoria' FROM produto")
            // remover a tabela antiga
            database.execSQL("DROP TABLE IF EXISTS `Produto`")
            //renomear tabela nova para o nome da tabela antiga
            database.execSQL("ALTER TABLE nova RENAME TO `Produto`")
        }
    }

    fun getInstance(context : Context): DatabaseMercadinho{
       return Room
            .databaseBuilder(context, DatabaseMercadinho::class.java,"database_mercadinho" )
            .allowMainThreadQueries()
            .addMigrations(MICRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
            .build()
    }
}


}