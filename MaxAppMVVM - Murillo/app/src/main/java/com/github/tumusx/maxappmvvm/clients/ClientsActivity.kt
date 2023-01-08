package com.github.tumusx.maxappmvvm.clients

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.tumusx.maxappmvvm.R
import com.github.tumusx.maxappmvvm.clients.charterClient.CharterFragment
import com.github.tumusx.maxappmvvm.clients.dataClients.presenter.fragment.ClientDataFragment
import com.github.tumusx.maxappmvvm.clients.historicClient.presenter.fragment.HistoricFragment
import com.github.tumusx.maxappmvvm.databinding.ActivityClientsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instanceClientsBinding()
        configureToolbar()
        setupAppBarConfiguration()
        configureTransactionFragment(ClientDataFragment())
        setContentView(binding.root)
    }

    private fun configureToolbar(tittleToolbar: String = getString(R.string.dados_cliente)) {
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = tittleToolbar
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuVoltar -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun configureTransactionFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment, fragment.tag)
            .commitAllowingStateLoss()
    }

    private fun setupAppBarConfiguration() {
        binding.bottomNavigationView.setOnItemSelectedListener { itemSelect ->
            val itemFragmentSelect = when (itemSelect.itemId) {
                R.id.dados -> ClientDataFragment()
                R.id.historico -> HistoricFragment()
                R.id.alvaras -> CharterFragment()
                else -> ClientDataFragment()
            }
            configureToolbar(itemSelect.title.toString())
            itemSelect.isChecked = true
            configureTransactionFragment(itemFragmentSelect)
            false
        }
    }

    private fun instanceClientsBinding() {
        binding = ActivityClientsBinding.inflate(layoutInflater)
    }

    override fun finish() {
        overridePendingTransition(R.anim.anim_left_out, R.anim.anim_right_out)
        super.finish()
    }
}