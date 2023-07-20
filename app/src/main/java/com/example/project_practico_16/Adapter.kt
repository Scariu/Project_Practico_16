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
    var callBack: PaisCallBack? = null


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
    fun setPaisCallBack(c: PaisCallBack){
        this.callBack = c
    }
   inner class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemPais: Pais) {
            val texto = "${itemPais.nombre} tiene una población de ${itemPais.poblacion} habitantes."
            binding.textViewPais.text = itemPais.nombre
            binding.imageViewPais.load(itemPais.imgUrl)
            binding.cardViewItem.setOnClickListener(View.OnClickListener {
                callBack?.showCountry(texto)
            })

        }

    }

}

interface PaisCallBack{
    fun showCountry(s: String)
}
