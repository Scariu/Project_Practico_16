package com.example.project_practico_16

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.project_practico_16.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return paises.size
    }
    fun setData(listaPaises: List<Pais>){
        this.paises = listaPaises.toMutableList()
    }
    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemPais: Pais) {
            val texto = "${itemPais.nombre} tiene una poblacion de ${itemPais.poblacion} habitantes."
            binding.textViewPais.text = itemPais.nombre
            binding.imageViewPais.load(itemPais.imgUrl)
            binding.cardViewItem.setOnClickListener(View.OnClickListener {
                Toast.makeText(itemView.context, texto, Toast.LENGTH_LONG).show()
            })

        }

    }

}
