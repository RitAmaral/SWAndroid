package com.example.tp_mob_anaritaamaral

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tp_mob_anaritaamaral.model.Curso
import com.example.tp_mob_anaritaamaral.model.Utilizador
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale

class DBHelper (context: Context) : SQLiteOpenHelper(context, "dbusers", null, 1) { //"nome da base de dados"
    //implementar membros (oncreate e onupgrade)

    val sql = arrayOf(
        "CREATE TABLE utilizador (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT);",
        "INSERT INTO utilizador (username, password) VALUES ('user','pass')",
        "INSERT INTO utilizador (username, password) VALUES ('Rita','123')",
        "INSERT INTO utilizador (username, password) VALUES ('Bruno','prof')"
    ) //Na tabela de utilizadores já temos 3 users com login aprovado ^

    override fun onCreate(db: SQLiteDatabase?) {
        sql.forEach {
            db?.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE utilizador")
        onCreate(db)
    }

    //Inserir utilizador:
    fun insertUtilizador(username: String, password: String): Long {
        val db = this.writableDatabase //ligação à base de dados, e vão ser feitas alterações por isso colocar writableDatabase
        val contentValues = ContentValues() //vou colocar os elementos que quero inserir no meu insert (funciona como o intent)
        contentValues.put("username", username) //"nome da coluna", valor que estou a passar
        contentValues.put("password", password)
        val res = db.insert("utilizador", null, contentValues) //inserir na table utilizador os contentValues
        db.close() //para fechar a ligação
        return res
    }

    //Inserir curso:
    fun insertCurso(nome: String, local: String,
                    dataInicial: Date, dataFinal: Date, preco: Double,
                    duracao: Int, edicao: String) : Long {
        val db = this.writableDatabase //ligação à base de dados
        val contentValues = ContentValues()
        contentValues.put("nome", nome)
        contentValues.put("local", local)
        contentValues.put("dataInicial", SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(dataInicial))
        contentValues.put("dataFinal", SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(dataFinal))
        contentValues.put("preco", preco)
        contentValues.put("duracao", duracao)
        contentValues.put("edicao", edicao)
        val res = db.insert("cursos", null, contentValues) //inserir na table cursos os contentValues
        db.close() //para fechar a ligação
        return res
    }

    //Atualizar Utilizador -- isto não precisa/vai ser usado
    fun updateUtilizador(id: Int, username: String, password: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val res = db.update("utilizador", contentValues,"id=?",arrayOf(id.toString()))
        db.close() //para fechar a ligação
        return res
    }

    //Atualizar Curso
    fun updateCurso(id: Int, nome: String, local: String,
                    dataInicial: Date, dataFinal: Date, preco: Double,
                    duracao: Int, edicao: String) : Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("nome", nome)
        contentValues.put("local", local)
        contentValues.put("dataInicial", SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(dataInicial))
        contentValues.put("dataFinal", SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(dataFinal))
        contentValues.put("preco", preco)
        contentValues.put("duracao", duracao)
        contentValues.put("edicao", edicao)
        val res = db.update("cursos", contentValues, "id=?", arrayOf(id.toString()))
        db.close() //para fechar a ligação
        return res
    }

    //Remover Utilizador -- isto não precisa/vai ser usado
    fun deleteUtilizador(id: Int): Int { //colocar aqui o Int que apareceu quando passamos em cima do delete
        val db = this.writableDatabase
        val res = db.delete("utilizador","id=?",arrayOf(id.toString())) //se tiver a dar erro, passar em cima do delete, e ver que tem Int, logo colocar em cima ^
        db.close() //para fechar a ligação
        return res
    }

    //Remover Curso
    fun deleteCurso(id: Int) : Int {
        val db = this.writableDatabase
        val res = db.delete("cursos", "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }

    //Selecionar todos os Utilizadores
    fun selectAllUtilizadorCursor(): Cursor {
        val db = this.readableDatabase //aqui já não fazemos alterações na base de dados, por isso colocamos readableDatabase
        val cursor = db.rawQuery("SELECT * FROM utilizador", null)
        db.close()
        return cursor
    }

    //Selecionar todos os Cursos
    fun selectAllCursoCursor(): Cursor {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM cursos", null)
        db.close()
        return cursor
    }

    //Selecionar Utilizadores pelo ID, devolve o Cursor
    fun selectUtilizadorByIDCursor(id: Int): Cursor {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM utilizador WHERE id = ?", arrayOf(id.toString()))
        db.close()
        return cursor
    }

    //Selecionar Cursos pelo ID, devolve o Cursor
    fun selectCursoByIDCursor(id: Int): Cursor {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM cursos WHERE id = ?", arrayOf(id.toString()))
        db.close()
        return cursor
    }

    //Selecionar Utilizadores pelo ID, devolve o objeto utilizador
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

    //Selecionar Cursos pelo ID, devolve o objeto curso
    fun selectCursoByIDObjeto(id: Int): Curso {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM cursos WHERE id = ?", arrayOf(id.toString()))

        var curso: Curso = Curso()

        if (cursor.count == 1) {
            cursor.moveToFirst() //aponta cursor para primeiro registo

            //busco as posições de id, nome, local, ... na tabela
            val idIndex = cursor.getColumnIndex("id") //guarda a posição onde está o id
            val nomeIndex = cursor.getColumnIndex("nome")
            val localIndex = cursor.getColumnIndex("local")
            val dataInicialIndex = cursor.getColumnIndex("dataInicial")
            val dataFinalIndex = cursor.getColumnIndex("dataFinal")
            val precoIndex = cursor.getColumnIndex("preco")
            val duracaoIndex = cursor.getColumnIndex("duracao")
            val edicaoIndex = cursor.getColumnIndex("edicao")

            //carrego dados de id, nome, local, ... para varáveis locais
            val id = cursor.getInt(idIndex)
            val nome = cursor.getString(nomeIndex)
            val local = cursor.getString(localIndex)
            val dataInicial1 = cursor.getString(dataInicialIndex)
            val dataFinal1 = cursor.getString(dataFinalIndex)
            val preco = cursor.getString(precoIndex)
            val duracao = cursor.getInt(duracaoIndex)
            val edicao = cursor.getString(edicaoIndex)

            //acrescentar para as datas não darem erro
            val formatoData = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val dataInicial = formatoData.parse(dataInicial1)
            val dataFinal = formatoData.parse(dataFinal1)

            curso = Curso(id, nome, local, dataInicial, dataFinal, preco, duracao, edicao)
        }
        db.close()
        return curso
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

    fun selectAllCursosLista(): ArrayList<Curso> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM cursos", null)

        val listaCursos: ArrayList<Curso> = ArrayList()

        if (cursor.count > 0) {
            cursor.moveToFirst() //tava a apontar para o ultimo registo, agora aponta para o primeiro
            val idIndex = cursor.getColumnIndex("id") //guarda a posição onde está o id
            val nomeIndex = cursor.getColumnIndex("nome")
            val localIndex = cursor.getColumnIndex("local")
            val dataInicialIndex = cursor.getColumnIndex("dataInicial")
            val dataFinalIndex = cursor.getColumnIndex("dataFinal")
            val precoIndex = cursor.getColumnIndex("preco")
            val duracaoIndex = cursor.getColumnIndex("duracao")
            val edicaoIndex = cursor.getColumnIndex("edicao")

            do {
                val id = cursor.getInt(idIndex)
                val nome = cursor.getString(nomeIndex)
                val local = cursor.getString(localIndex)
                val dataInicial1 = cursor.getString(dataInicialIndex)
                val dataFinal1 = cursor.getString(dataFinalIndex)
                val preco = cursor.getString(precoIndex)
                val duracao = cursor.getInt(duracaoIndex)
                val edicao = cursor.getString(edicaoIndex)

                //acrescentar para as datas não darem erro
                val formatoData = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val dataInicial = formatoData.parse(dataInicial1)
                val dataFinal = formatoData.parse(dataFinal1)

                listaCursos.add(Curso(id, nome, local, dataInicial, dataFinal, preco, duracao, edicao))
            } while (cursor.moveToNext())
        }
        db.close()
        return listaCursos
    }

}