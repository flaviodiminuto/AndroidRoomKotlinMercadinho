package com.flavio.android.androidroomkotlinmercadinho.model

import androidx.room.*

@Entity(
    tableName = "compraproduto",
    indices = [Index(value = arrayOf("compra_id")), Index(value = arrayOf("produto_id"))],
    foreignKeys = [ForeignKey(
    entity = Compra::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("compra_id"),
    onDelete = ForeignKey.CASCADE,
    onUpdate = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = Produto::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("produto_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
class CompraProduto {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    @ColumnInfo(name = "compra_id") var compraId : Int = 0
    @ColumnInfo(name = "produto_id")var produtoId : Int = 0

    constructor()

    @Ignore
    constructor(id: Int, compraId: Int, produtoId: Int) {
        this.id = id
        this.compraId = compraId
        this.produtoId = produtoId
    }


}