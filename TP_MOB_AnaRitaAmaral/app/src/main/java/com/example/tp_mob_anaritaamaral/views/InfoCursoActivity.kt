package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.databinding.ActivityInfoCursoBinding
import com.example.tp_mob_anaritaamaral.model.Curso

class InfoCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoCursoBinding
    private lateinit var db: DBHelper
    private lateinit var curso: Curso
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private var imageid: Int? = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ligação à base de dados
        db = DBHelper(this)
        val i = intent
        val id = i.extras?.getInt("id")

        //curso = db.selectCursoByIDObjeto(i.getIntExtra("id", 0))
        //curso = id?.let { db.selectCursoByIDObjeto(it) }!!


        if (id != null) {
            curso = db.selectCursoByIDObjeto(id)
            buscar()
        } else {
            finish()
        }

        binding.botaoEditar.setOnClickListener {
            val res = db.updateCurso(
                id = curso.id,
                nome = binding.editNome.text.toString(),
                local = binding.editLocal.text.toString(),
                dataInicial = binding.editInicio.text.toString(),
                dataFinal = binding.editFim.text.toString(),
                preco = binding.editPreco.text.toString().toInt(),
                duracao = binding.editDuracao.text.toString().toInt(),
                edicao = binding.editEdicao.text.toString(),
                imagemID = curso.imagemID
            )

            if (res > 0) {
                Toast.makeText(applicationContext, "Curso editado com sucesso", Toast.LENGTH_SHORT).show()
                setResult(1, i)
                finish()
            } else {
                Toast.makeText(applicationContext, "Curso não editado", Toast.LENGTH_SHORT).show()
                setResult(0, i)
                finish()
            }
            /*
            val imagemID = binding.textImagem.text.toString().toInt()
            val nome = binding.textNome.text.toString()
            val local = binding.textLocal.text.toString()
            val inicio = binding.textInicio.text.toString()
            val fim = binding.textFim.text.toString()
            val preco = binding.textPreco.text.toString().toDouble()
            val duracao = binding.textDuracao.text.toString().toInt()
            val edicao = binding.textEdicao.text.toString() */


            /*
            if (nome.isNotEmpty() && local.isNotEmpty() && inicio.isNotEmpty() && fim.isNotEmpty()
                && preco.isNotEmpty() && duracao != null && edicao.isNotEmpty() && imagemID != null) {
                val res = db.insertCurso(nome, local, inicio, fim, preco, duracao, edicao, imagemID)
                if (res>0) {
                    Toast.makeText(applicationContext, "Curso editado com sucesso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Curso não editado", Toast.LENGTH_SHORT).show()
                }
            }*/
        }
        binding.botaoEliminar.setOnClickListener {
            val res = db.deleteCurso(curso.id)
            if (res > 0) {
                Toast.makeText(applicationContext, getString(R.string.curso_eliminado), Toast.LENGTH_SHORT).show()
                setResult(1, i)
                finish()
            } else {
                Toast.makeText(applicationContext, getString(R.string.curso_nao_foi_eliminado), Toast.LENGTH_SHORT).show()
                setResult(0, i)
                finish()
            }
        }
        binding.imagemCesae.setOnClickListener {
            launcher.launch(Intent(applicationContext, ImagemSelecionarActivity::class.java))
        }
        
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                imageid = it.data?.extras?.getInt("id")
                binding.imagemCesae.setImageDrawable(resources.getDrawable(imageid!!))
            } else {
                imageid = -1
                binding.imagemCesae.setImageResource(R.drawable.iconcesae)
            }
        }

    }
    private fun buscar() {
            binding.editNome.setText(curso.nome)
            binding.editLocal.setText(curso.local)
            binding.editInicio.setText(curso.dataInicial)
            binding.editFim.setText(curso.dataFinal)
            binding.editPreco.setText(curso.preco.toString().toInt())
            binding.editDuracao.setText(curso.duracao.toString().toInt())
            binding.editEdicao.setText(curso.edicao)
            if (curso.imagemID > 0) {
                binding.imagemCesae.setImageDrawable(resources.getDrawable(curso.imagemID))
            } else {
                binding.imagemCesae.setImageResource(R.drawable.iconcesae) //imagem default
            }
        }
}