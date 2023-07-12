package com.example.a16_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user") //na minha base de dados vou ter uma tabela chamada user
class UserModel {

    @PrimaryKey(autoGenerate = true) //vai gerar automaticamente
    @ColumnInfo(name="id") //nome da coluna na base de dados
    var id: Int = 0

    @ColumnInfo(name="username")
    var username: String = ""

    @ColumnInfo(name="password")
    var password: String = ""

    override fun toString(): String {
        return username
    }

}