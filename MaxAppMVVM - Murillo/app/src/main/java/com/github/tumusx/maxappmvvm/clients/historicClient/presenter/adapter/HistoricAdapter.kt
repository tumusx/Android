package com.github.tumusx.maxappmvvm.clients.historicClient.presenter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.maxappmvvm.databinding.HistoricContainerItemsBinding

class HistoricAdapter : RecyclerView.Adapter<HistoricAdapter.HistoricViewHolder>() {

    class HistoricViewHolder(val binding: HistoricContainerItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setupUI() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HistoricViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}