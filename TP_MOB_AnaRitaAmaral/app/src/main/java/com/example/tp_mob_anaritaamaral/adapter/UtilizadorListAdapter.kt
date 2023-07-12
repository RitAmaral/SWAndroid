package com.example.tp_mob_anaritaamaral.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.model.Utilizador

//estrutura necessária que um adapter precisa
class UtilizadorListAdapter (val listaUtilizadores: ArrayList<Utilizador>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<UtilizadorListAdapter.UtilizadorViewHolder>()  {

    class UtilizadorViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) { //vai buscar a linha da recycler view:
        //referenciar todos os elementos que colocamos na row_utilizador_list:
        val textView: TextView = itemView.findViewById(R.id.text_username) //text_username -> row_utilizador_list
    }

    class OnClickListener(val clickListener: (utilizador: Utilizador) -> Unit) { //Unit adiciona funcionalidades ao utilizador
        fun onClick(utilizador: Utilizador) = clickListener(utilizador)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UtilizadorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_utilizador_list, parent, false)
        return UtilizadorViewHolder(view)
    }

    override fun onBindViewHolder(holder: UtilizadorViewHolder, position: Int) {
        val utilizador = listaUtilizadores[position] //posição específica: 1, 2, 3, ...
        holder.textView.text = utilizador.username //vai colocar o username na linha respetiva da recycler view
        holder.itemView.setOnClickListener {
            onClickListener.onClick(utilizador)
        }
    }

    override fun getItemCount(): Int {
        return listaUtilizadores.size
    }

}