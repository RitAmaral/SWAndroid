package com.example.a07_listalistviewstring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_listalistviewstring.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNomes = ArrayList<String>()
        listaNomes.add("Rita") //adiciona
        listaNomes.add("Ana")
        listaNomes.add("Carlos")
        listaNomes.add("Natália")
        listaNomes.add("Joana")
        listaNomes.add("Fábio")
        listaNomes.remove("Ana") //remove a Ana, no entanto devemos remover pela posição, pq podemos ter mais que uma Ana, e removia uma delas

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)
        //este adaptador recebeu a listagem de nomes, e agora vai alimentar a list view
        binding.listViewNomes.adapter = arrayAdapter

        //clicar num item da lista:
        binding.listViewNomes.setOnItemClickListener { parent, view, position, id -> //posso retirar parent, view e id se não estiver a utilizar, e coloco _
            //Toast.makeText(applicationContext, "Posição ${position}", Toast.LENGTH_SHORT).show()
                //position: diz a posição, exemplo, Rita: 0, Carlos: 1 (pq ana foi removido)
            //Toast.makeText(applicationContext, listaNomes.get(position), Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, listaNomes[position], Toast.LENGTH_SHORT).show()
            binding.editNome.setText(listaNomes[position]) //sempre que clico num nome, aparece o nome no campo editNome
            pos = position //extrair e guardar a posição que for clicada
            // [position] diz o nome: Rita
        }

        binding.listViewNomes.setOnItemLongClickListener { _, _, position, _ -> //se clicar durante muito tempo aparece a posição: 0, 1, ..
            Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
            return@setOnItemLongClickListener true //ou colocar apenas: true
        }

        binding.buttonAdicionar.setOnClickListener {
            val nome = binding.editNome.text.toString() //ler nome inserido pelo utilizador
            listaNomes.add(nome) //adicionar o nome de utilizador à lista
            arrayAdapter.notifyDataSetChanged() //vai dizer que houve uma alteração à lista, e reatuliza-se
            //se refresh na app, estes elementos adicionados por aqui voltam a desaparecer
        }

        binding.buttonEditar.setOnClickListener {
            if (pos >= 0 && pos < listaNomes.size) {
                listaNomes[pos] = binding.editNome.text.toString()
                pos = -1
                arrayAdapter.notifyDataSetChanged()
            }
        }

        binding.buttonEliminar.setOnClickListener {
            if (pos >= 0 && pos < listaNomes.size) {
                listaNomes.removeAt(pos) //remove at remova a posição, remove só apaga o "nome"
                pos = -1 //como -1 tá fora do intervalo lá em cima, resolve o problema, só volta a eliminar quando clicarmos numa posição válida
                arrayAdapter.notifyDataSetChanged()
            }
        }
    }
}