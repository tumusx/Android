package com.github.tumusx.maxappmvvm.clients

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.github.tumusx.maxappmvvm.R
import com.github.tumusx.maxappmvvm.clients.charterClient.CharterFragment
import com.github.tumusx.maxappmvvm.clients.dataClients.presenter.fragment.ClientDataFragment
import com.github.tumusx.maxappmvvm.clients.historicClient.presenter.fragment.HistoricFragment
import com.github.tumusx.maxappmvvm.commons.extension.customSnackBar
import com.github.tumusx.maxappmvvm.databinding.ActivityClientsBinding
import com.google.android.material.snackbar.Snackbar
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

    private fun visibilitySearch(isVisible: Boolean) {
        binding.llContainerSearch.isVisible = isVisible
        binding.searchItem.setOnClickListener { showKeyboard() }
        binding.imgMore.setOnClickListener { binding.root.customSnackBar("LEGENDAS - NAO FEITA", Snackbar.LENGTH_LONG) }
    }

    private fun showKeyboard() {
        val inputMethodManager: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(
            binding.root.applicationWindowToken,
            InputMethodManager.SHOW_FORCED, 0
        )
    }

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
            var isVisibleSearch: Boolean = false
            val itemFragmentSelect = when (itemSelect.itemId) {
                R.id.dados -> {
                    isVisibleSearch = false
                    ClientDataFragment()
                }
                R.id.historico -> {
                    isVisibleSearch = true
                    HistoricFragment()
                }
                R.id.alvaras -> {
                    isVisibleSearch = false
                    CharterFragment()
                }
                else -> ClientDataFragment()
            }
            visibilitySearch(isVisibleSearch)
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