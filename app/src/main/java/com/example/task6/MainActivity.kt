package com.example.task6

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    private lateinit var adapter: Adapter
    private lateinit var recyclerView :RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        recyclerView = findViewById(R.id.recyclerView)
        adapter = Adapter(this)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this)
        recyclerView.adapter = adapter
        recyclerView.hasFixedSize()
    }

    private fun initViewModel(){
        val viewModel : ViewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.getLiveDataObserver().observe(this, Observer {
          adapter.setGamesList(it)
            adapter.notifyDataSetChanged()
        })
        viewModel.addGames()

    }

    companion object {
        private var instance: MainActivity? = null
        fun getContext(): Context? {
            return instance
        }
    }
}