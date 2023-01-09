package com.github.tumusx.maxappmvvm.clients.historicClient.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.Pedido
import com.github.tumusx.maxappmvvm.clients.historicClient.presenter.adapter.HistoricAdapter
import com.github.tumusx.maxappmvvm.clients.historicClient.presenter.viewModel.HistoricClientViewModel
import com.github.tumusx.maxappmvvm.commons.extension.customSnackBar
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import com.github.tumusx.maxappmvvm.databinding.FragmentHistoricClientBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoricFragment : Fragment() {
    private lateinit var binding: FragmentHistoricClientBinding
    private val viewModel: HistoricClientViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricClientBinding.inflate(layoutInflater)
        onConfigureObservables()
        viewModel.searchHistoricResponse()
        return binding.root
    }

    private fun onConfigureObservables() {
        viewModel.stateUI.observe(viewLifecycleOwner) { state ->
            configureStateUI(state)
        }
    }

    private fun setUpAdapter(request: List<Pedido>) {
        val historicAdapter = HistoricAdapter()
        historicAdapter.updateList(request)
        binding.rvRequest.adapter = historicAdapter
    }

    private fun configureStateUI(stateUI: StateUI) {
        when (stateUI) {
            is StateUI.Success<*> -> {
                binding.llProgressLayout.visibility = View.GONE
                binding.rvRequest.visibility = View.VISIBLE
                setUpAdapter((stateUI.data as List<Pedido>))
            }

            is StateUI.Error -> {
                binding.llProgressLayout.visibility = View.GONE
                binding.rvRequest.visibility = View.VISIBLE
                binding.root.customSnackBar(stateUI.messageError, Snackbar.LENGTH_LONG)
            }

            is StateUI.IsLoading -> {
                binding.llProgressLayout.visibility = View.VISIBLE
                binding.rvRequest.visibility = View.GONE
            }

        }
    }
}