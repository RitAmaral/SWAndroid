package com.example.a14_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.ArrayList

class DBHelper(context: Context) : SQLiteOpenHelper(context, "dbexemplo", null, 1) { //"nome da base de dados"
    //implementar membros (oncreate e onupgrade)

    val sql = arrayOf(
        "CREATE TABLE utilizador (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT);",
        "INSERT INTO utilizador (username, password) VALUES ('admin','pass')",
        "INSERT INTO utilizador (username, password) VALUES ('user','pwd')"
    )

    override fun onCreate(db: SQLiteDatabase?) {
        sql.forEach {
            db?.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE utilizador")
        onCreate(db)
    }

    fun insertUtilizador(username: String, password: String): Long { //long é maior que um inteiro
        val db = this.writableDatabase //ligação à base de dados, e vão ser feitas alterações por isso colocar writableDatabase
        val contentValues = ContentValues() //vou colocar os elementos que quero inserir no meu insert (tipo intent)
        contentValues.put("username", username) //"nome da coluna", valor que estou a passar
        contentValues.put("password", password)
        val res = db.insert("utilizador", null, contentValues) //inserir na table utilizador os contentValues
        db.close() //para fechar a ligação
        return res
    }

    fun updateUtilizador(id: Int, username: String, password: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val res = db.update("utilizador", contentValues,"id=?",arrayOf(id.toString()))
        db.close() //para fechar a ligação
        return res
    }

    fun deleteUtilizador(id: Int): Int { //colocar aqui o Int que apareceu quando passamos em cima do delete
        val db = this.writableDatabase
        val res = db.delete("utilizador","id=?",arrayOf(id.toString())) //se tiver a dar erro, passar em cima do delete, e ver que tem Int, logo colocar em cima ^
        db.close() //para fechar a ligação
        return res
    }

    fun selectAllUtilizadorCursor(): Cursor {
        val db = this.readableDatabase //aqui já não fazemos alterações na base de dados, por isso colocamos readableDatabase
        val cursor = db.rawQuery("SELECT * FROM utilizador", null)
        db.close()
        return cursor
    }

    fun selectUtilizadorByIDCursor(id: Int): Cursor {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM utilizador WHERE id = ?", arrayOf(id.toString()))
        db.close()
        return cursor
    }
    fun selectUtilizadorByIDObjeto(id: Int): Utilizador {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM utilizador WHERE id = ?", arrayOf(id.toString()))

        var utilizador: Utilizador = Utilizador()

        if (cursor.count == 1) {
            cursor.moveToFirst() //aponta cursor para primeiro registo

            //busco as posições de id, username e password na tabela
            val idIndex = cursor.getColumnIndex("id") //guarda a posição onde está o id
            val usernameIndex = cursor.getColumnIndex("username")
            val passwordIndex = cursor.getColumnIndex("password")

            //carrego dados de id, username e password para varáveis locais
            val id = cursor.getInt(idIndex)
            val username = cursor.getString(usernameIndex)
            val password = cursor.getString(passwordIndex)

            utilizador = Utilizador(id, username, password)
        }
        db.close()
        return utilizador
    }

    fun selectAllUtilizadorLista(): ArrayList<Utilizador> {
        val db = this.readableDatabase //aqui já não fazemos alterações na base de dados, por isso colocamos readableDatabase
        val cursor = db.rawQuery("SELECT * FROM utilizador", null)

        val listaUtilizador: ArrayList<Utilizador> = ArrayList()

        if (cursor.count > 0) {
            cursor.moveToFirst() //tava a apontar para o ultimo registo, agora aponta para o primeiro
            val idIndex = cursor.getColumnIndex("id") //guarda a posição onde está o id
            val usernameIndex = cursor.getColumnIndex("username")
            val passwordIndex = cursor.getColumnIndex("password")
            do {
                val id = cursor.getInt(idIndex)
                val username = cursor.getString(usernameIndex)
                val password = cursor.getString(passwordIndex)
                listaUtilizador.add(Utilizador(id, username, password))
            } while (cursor.moveToNext())
        }
        db.close()
        return listaUtilizador
    }

}