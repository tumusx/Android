package com.github.tumusx.maxappmvvm.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.github.tumusx.maxappmvvm.clients.ClientsActivity
import com.github.tumusx.maxappmvvm.databinding.ActivityMenuBinding
import com.github.tumusx.maxappmvvm.menu.adapter.MenuAdapter

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instanceMenuBinding()
        configAdapterHome()
        setContentView(binding.root)
    }

    private fun instanceMenuBinding() {
        binding = ActivityMenuBinding.inflate(layoutInflater)
    }

    private fun goToClientScreen() =
        startActivity(Intent(this@MenuActivity, ClientsActivity::class.java))


    private fun instanceAdapter() = MenuAdapter { goToClientScreen() }


    private fun configAdapterHome() {
        binding.rvItemsHome.adapter = instanceAdapter()
        binding.rvItemsHome.layoutManager = GridLayoutManager(this, 2)
        binding.rvItemsHome.setHasFixedSize(true)
    }
}