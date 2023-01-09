package com.github.tumusx.maxappmvvm.clients.historicClient.presenter.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.maxappmvvm.R
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.Pedido
import com.github.tumusx.maxappmvvm.clients.historicClient.enumType.CaptionsType
import com.github.tumusx.maxappmvvm.clients.historicClient.enumType.CaptionsUtils
import com.github.tumusx.maxappmvvm.databinding.HistoricContainerItemsBinding

class HistoricAdapter : RecyclerView.Adapter<HistoricAdapter.HistoricViewHolder>() {
    private var updateHistoricList = emptyList<Pedido>()
    private val captionsUtils = CaptionsUtils()

    companion object {
        const val PROCESS_REQUEST = "Em processamento"
        const val ORCAMENTO = "ORCAMENTO"
    }

    class HistoricViewHolder(private val binding: HistoricContainerItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun setupUI(request: Pedido, captionsUtils: CaptionsUtils) {
            binding.txtNumeroPedidoClient.text = request.numeroPedRca.toString()
            binding.txtClienteNumeroCliente.text =
                request.codigoCliente + " - " + request.nomeClient
            binding.txtStatus.text = request.status
            binding.txtValue.text = "-"
            if (request.critica == null) binding.icAwaitCrLegenda.visibility = View.GONE
            request.critica?.let {
                binding.icAwaitCrLegenda.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    captionsUtils.pegarCritica(request.critica),
                    0
                )
            }
            //binding.txtTimeZone.text = simpleDateFormat(request.data)
            configureIconCaption(request.tipo, request.status)
            configureCaptionsIcons(captionsUtils, request)
        }

        private fun configureIconCaption(tipo: String, status: String) {
            if (status == PROCESS_REQUEST) {
                binding.icStatusLegenda.imgIcon.setImageResource(CaptionsType.EM_PROCESSAMENTO_PEDIDO.drawable)
                binding.icStatusLegenda.imgIcon.visibility = View.VISIBLE
                binding.icStatusLegenda.llLayoutRounded.backgroundTintList =
                    ColorStateList.valueOf(binding.root.context.getColor(R.color.text_labs))
                binding.icStatusLegenda.txtIcon.visibility = View.GONE
            } else {
                val captionsType = CaptionsType.requestType(tipo)
                binding.icStatusLegenda.imgIcon.visibility = View.GONE
                binding.icStatusLegenda.txtIcon.visibility = View.VISIBLE
                binding.icStatusLegenda.txtIcon.text = captionsType.charCaption
                val color = if (tipo == ORCAMENTO) {
                    R.color.blue_color_es
                } else {
                    R.color.company_name
                }
                binding.icStatusLegenda.llLayoutRounded.backgroundTintList =
                    ColorStateList.valueOf(binding.root.context.getColor(color))
            }
        }

        private fun configureCaptionsIcons(captionsUtils: CaptionsUtils, pedido: Pedido) {
            if (pedido.legendas?.isEmpty() == true || pedido.legendas == null) return
            binding.imgStatusIcon.setImageResource(captionsUtils.pegarLegendaIcone(pedido.legendas.first()))
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(requestList: List<Pedido>) {
        updateHistoricList = requestList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HistoricViewHolder(
        HistoricContainerItemsBinding.inflate(
            LayoutInflater.from(parent.context)
        )
    )

    override fun onBindViewHolder(holder: HistoricViewHolder, position: Int) {
        holder.setupUI(updateHistoricList[position], captionsUtils)
    }

    override fun getItemCount() = updateHistoricList.size
}