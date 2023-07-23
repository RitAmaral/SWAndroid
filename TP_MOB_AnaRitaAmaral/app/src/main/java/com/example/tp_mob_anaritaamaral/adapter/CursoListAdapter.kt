package com.example.tp_mob_anaritaamaral.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.model.Curso
import kotlinx.coroutines.NonDisposableHandle.parent

class CursoListAdapter (val listaCursos: ArrayList<Curso>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<CursoListAdapter.CursoViewHolder>() {

    class CursoViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView) { //vai buscar a linha da recycler view:
        val textView: TextView = itemView.findViewById(R.id.text_nome) //text_nome -> row_curso_list
        //val imagem: ImageView = itemView.findViewById(R.id.imagem_cesae)
    }

    class OnClickListener(val clickListener: (curso: Curso) -> Unit) {
        fun onClick(curso: Curso) = clickListener(curso)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_curso_list, parent, false)
        return CursoViewHolder(view)
    }

    override fun getItemCount(): Int { //quantos elementos temos na lista de cursos
        return listaCursos.size
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]

        holder.textView.setText("$curso")
        /*
        if (curso.imagemID > 0) {
            holder.imagem.setImageResource(curso.imagemID)
        } else {
            holder.imagem.setImageResource(R.drawable.iconcesae)
        }*/

        holder.itemView.setOnClickListener {
            onClickListener.onClick(curso)
        }
    }
}