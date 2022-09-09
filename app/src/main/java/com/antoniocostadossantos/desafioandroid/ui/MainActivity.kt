package com.antoniocostadossantos.desafioandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoniocostadossantos.desafioandroid.adapter.ItemAdapter
import com.antoniocostadossantos.desafioandroid.databinding.ActivityMainBinding
import com.antoniocostadossantos.desafioandroid.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupRecyclerView()
        setupObserver()
    }

    private fun setupObserver() {
        userViewModel.liveRepo.observe(this) { response ->
            adapter.setList(response.sortedByDescending {
                it.stargazers_count
            })
        }
    }

    private fun setupRecyclerView() {
        this.adapter = ItemAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.adapter = this.adapter
    }
}