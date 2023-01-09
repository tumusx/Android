package com.github.tumusx.maxappmvvm.clients.dataClients.presenter.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.tumusx.maxappmvvm.R
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.Contato
import com.github.tumusx.maxappmvvm.clients.dataClients.presenter.adapter.ContactAdapter
import com.github.tumusx.maxappmvvm.clients.dataClients.presenter.viewModel.ClientDataViewModel
import com.github.tumusx.maxappmvvm.commons.extension.customSnackBar
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import com.github.tumusx.maxappmvvm.databinding.FragmentClientDataBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientDataFragment : Fragment() {
    private lateinit var binding: FragmentClientDataBinding
    private val viewModel: ClientDataViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClientDataBinding.inflate(layoutInflater)
        configureObservables()
        viewModel.searchClientRemote()
        return binding.root
    }

    private fun setupAdapterClient(clientContact: List<Contato>) {
        val contactAdapter = ContactAdapter()
        binding.containerContactClient.rvContatos.adapter = contactAdapter
        contactAdapter.updateList(clientContact)
    }

    private fun configureObservables() {
        viewModel.stateUI.observe(viewLifecycleOwner) { stateUI ->
            configureStateUI(stateUI)
        }
    }

    private fun verifyStatusClient(statusClient: String) {
        binding.btnStatusClient.setOnClickListener {
            binding.root.customSnackBar(statusClient, Snackbar.LENGTH_SHORT)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun configureUI(dataClient: ClientDTO) {
        binding.dataClienteContainer.txtCpf.text = getString(R.string.INDEFINIDO)
        binding.dataClienteContainer.txtCnpj.text = dataClient.cnpj
        binding.dataClienteContainer.txtRamoAtividade.text = dataClient.ramoAtividade
        binding.dataClienteContainer.txtNameClient.text = dataClient.nomeFantasia
        binding.dataClienteContainer.txtEndereco.text = dataClient.endereco
        binding.dataClienteContainer.txtNomeClient.text =
            dataClient.codigo + " - " + dataClient.nomeFantasia
        setupAdapterClient(dataClient.contatos)
        verifyStatusClient(dataClient.status)
    }

    private fun configureStateUI(stateUI: StateUI) {
        when (stateUI) {
            is StateUI.Success<*> -> {
                binding.llContainer.visibility = View.VISIBLE
                binding.llProgressLayout.visibility = View.GONE
                configureUI((stateUI.data as ClientDTO))
            }

            is StateUI.Error -> {
                binding.llContainer.visibility = View.VISIBLE
                binding.llProgressLayout.visibility = View.GONE
                Snackbar.make(binding.root, stateUI.messageError, Snackbar.LENGTH_SHORT).show()
            }

            is StateUI.IsLoading -> {
                binding.llProgressLayout.visibility = View.VISIBLE
                binding.llContainer.visibility = View.GONE
            }

        }
    }
}