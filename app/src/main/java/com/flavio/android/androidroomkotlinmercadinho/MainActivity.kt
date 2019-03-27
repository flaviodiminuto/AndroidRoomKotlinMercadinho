package com.flavio.android.androidroomkotlinmercadinho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flavio.android.androidroomkotlinmercadinho.database.DatabaseMercadinho
import com.flavio.android.androidroomkotlinmercadinho.model.Compra
import com.flavio.android.androidroomkotlinmercadinho.model.CompraProduto
import com.flavio.android.androidroomkotlinmercadinho.model.Produto
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar
//Para testar descomente as linhas 19, 23  e 41

class MainActivity : AppCompatActivity() {

    private val text by lazy { texto }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Descomentar nas primeiras execuçoes para popular o banco com produtos.
        //geraListaDeProdutos()
        var compra = geraCompra()

        var t = ""
        var produtos = getDB().getProdutoDao().consultaTodasProdutos()
        for (produto in produtos){
          //Descomentar na primeira execução
         //   getDB().getCompraProdutoDao().salvarCompraProduto(CompraProduto(0,compra.id,produto.id))
            t += "\nId: ${produto.id} \tNome: ${produto.nome} \tPreço: R$${produto.valor} \t${produto.categoria}"
            compra.valor += produto.valor
        }
        t += "\n\nCompra: ${compra.id}\n" +
                "Valor: ${compra.valor}\n" +
                "Data e hora: ${compra.dataFormatada()}"
        text.text = t


    }

    private fun geraCompra(): Compra {
        val compra = Compra(0, 0.0, Calendar.getInstance())
        //Descomentar nas primeiras execucoes
       // getDB().getCompraDao().salvaCompra(compra) Salva a primeira compra no banco
        return getDB().getCompraDao().consultaCompra(1) //Somente a titulo de teste estou utilizando o indice zero
    }

    private fun getDB(): DatabaseMercadinho{
        return DatabaseMercadinho.getInstance(this)
    }

    private fun geraListaDeProdutos(){
        val produtos = arrayListOf(
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
