package com.flavio.android.androidroomkotlinmercadinho.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Produto {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var nome = ""
    var valor : Double = 0.0
    var categoria = ""

    constructor()

    @Ignore
    constructor(id: Int, nome: String, valor: Double, categoria : String) {
        this.id = id
        this.nome = nome
        this.valor = valor
        this.categoria = categoria
    }
}