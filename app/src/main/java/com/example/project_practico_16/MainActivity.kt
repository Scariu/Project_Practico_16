package com.example.project_practico_16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_practico_16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PaisCallBack {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter()
        val listaDePaises = PaisesLatam.paises
        adapter.setData(listaDePaises)
        adapter.setPaisCallBack(this)
        binding.recyclerView.adapter = adapter

    }

    override fun showCountry(s: String) {
        binding.textViewPoblacion.text = s
    }
}