package com.flavio.android.androidroomkotlinmercadinho.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity
class Compra {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var valor : Double = 0.0

    constructor()

    @Ignore
    constructor(id: Int, valor: Double) {
        this.id = id
        this.valor = valor
    }
}