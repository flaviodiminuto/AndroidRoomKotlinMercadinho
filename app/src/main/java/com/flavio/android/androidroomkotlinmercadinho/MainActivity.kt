package com.flavio.android.androidroomkotlinmercadinho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flavio.android.androidroomkotlinmercadinho.database.DatabaseMercadinho
import com.flavio.android.androidroomkotlinmercadinho.model.CompraProduto
import com.flavio.android.androidroomkotlinmercadinho.model.Produto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var compraProduto = CompraProduto()

    val text by lazy { texto }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        geraListaDeProdutos()

        var t = ""
        var produtos = getDB().getProdutoDao().consultaTodasProdutos()
        for (produto in produtos){
            t += "\nId: ${produto.id} \tNome: ${produto.nome} \tPreço: R$${produto.valor} \t${produto.categoria}"
        }
        text.text = t

    }

    fun getDB(): DatabaseMercadinho{
        return DatabaseMercadinho.getInstance(this)
    }

    fun geraListaDeProdutos(){
        var produtos = arrayListOf(
            Produto(0, "pao de meu", 5.0, "biscoito"),
            Produto( 0,"Coca-Cola",7.0, "bebida"),
            Produto( 0, "fandangos",3.0,"salgado"),
            Produto( 0,"Trakinas",2.0,"biscoito"),
            Produto(0,"Bis",4.0,"biscoito coberto")
        )
        for(produto in produtos)
            getDB().getProdutoDao().salvaProduto(produto)
    }

}
