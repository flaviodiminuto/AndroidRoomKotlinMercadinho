package com.flavio.android.androidroomkotlinmercadinho.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*


@Entity
class Compra {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var valor : Double = 0.0
    var data = Calendar.getInstance()

    constructor()

    @Ignore
    constructor(id: Int, valor: Double, data : Calendar) {
        this.id = id
        this.valor = valor
        this.data = data
    }

    fun dataFormatada(): String{
        val sdf = SimpleDateFormat("dd/MM/yyy HH:mm:ss")
        return sdf.format(this.data.time)
    }
}