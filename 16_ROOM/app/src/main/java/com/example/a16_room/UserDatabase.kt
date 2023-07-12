package com.example.a16_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserModel::class], version = 1) //quero um array da classe user model na nossa base de dados
abstract class UserDatabase : RoomDatabase() { //colocar abstract para não dar erro, pq não quero implementar os métodos aqui

    abstract fun userDAO() : UserDAO //vai buscar os métodos implementados na interface UserDAO

    companion object {
        private lateinit var  INSTANCE : UserDatabase

        fun getDatabase(context: Context): UserDatabase {
            if (!::INSTANCE.isInitialized) { //verifica se o objeto já foi inicializado ou não (Padrão de design Singleton)
                synchronized(UserDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "userDB") // "nome da base de dados"
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }

} //associar o UserDatabase ao UserModel