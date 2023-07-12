package com.example.a16_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao //Data Access Object
interface UserDAO {

    @Insert
    fun insert(user: UserModel): Long //vai fazer a inserção do utilizador

    @Update
    fun update(user: UserModel): Int

    @Delete
    fun delete(user: UserModel): Int

    @Query("SELECT * FROM user WHERE id = :id") // :id é igual ao id que estou a passar embaixo (id: Int)
    fun get(id: Int): UserModel

    @Query("SELECT * FROM user")
    fun getAll() : List<UserModel> //devolve a listam de todos os utilizadores

} //implementar aqui o nosso CRUD, os métodos que queremos utilizar!