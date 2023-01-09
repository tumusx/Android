package com.github.tumusx.maxappmvvm.clients.historicClient.enumType

import com.github.tumusx.maxappmvvm.R

class CaptionsUtils {
    fun pegarCritica(tipoCritica: String): Int {
        val criticas = mutableListOf<Pair<String, Int>>()
        criticas.add(Pair("AGUARDANDO_RETORNO_ERP", R.drawable.ic_maxima_aguardando_critica))
        criticas.add(Pair("SUCESSO", R.drawable.ic_maxima_critica_sucesso))
        criticas.add(Pair("FALHA_PARCIAL", R.drawable.ic_maxima_critica_alerta))
        criticas.add(Pair("FALHA_TOTAL", R.drawable.ic_error_alert))
        for (criticaItem in criticas) {
            if (criticaItem.first == tipoCritica) {
                return criticaItem.second
            }
        }
        return criticas[1].second
    }

    fun pegarLegendaIcone(tipoLegenda: String): Int {
        val legendas = mutableListOf<Pair<String, Int>>()
        legendas.add(Pair("PEDIDO_SOFREU_CORTE", R.drawable.ic_maxima_legenda_corte))
        legendas.add(Pair("PEDIDO_FEITO_TELEMARKETING", R.drawable.ic_maxima_legenda_telemarketing))
        legendas.add(Pair("PEDIDO_CANCELADO_ERP", R.drawable.ic_maxima_legenda_cancelamento))
        for (legendaItem in legendas) {
            if (legendaItem.first == tipoLegenda) {
                return legendaItem.second
            }
        }
        return legendas[1].second
    }
}

enum class CaptionsType(
    val descriptionCaption: Int,
    val drawable: Int = R.drawable.ic_maxima_em_processamento,
    val charCaption: String = "",
    val color: Int
) {
    EM_PROCESSAMENTO_PEDIDO(
        R.string.processamento_status,
        R.drawable.ic_maxima_em_processamento,
        color = R.color.status_color_connection
    ),
    PEDIDO_RECUSADO_ERP(
        R.string.recusado_status,
        charCaption = "!",
        color = R.color.color_error_refused
    ),
    PEDIDO_PENDENTE_ERP(
        R.string.pendente_status,
        charCaption = "P",
        color = R.color.company_name
    ),
    PEDIDO_BLOQUEADO_ERP(
        R.string.bloqueado_status,
        charCaption = "B",
        color = R.color.blue_color_cl
    ),
    PEDIDO_LIBERADO_ERP(
        R.string.liberado_status,
        charCaption = "L",
        color = R.color.blue_color_es
    ),
    PEDIDO_MONTADO_ERP(R.string.montado_status, charCaption = "M", color = R.color.mounted),
    PEDIDO_FATURADO_ERP(
        R.string.faturado_status,
        charCaption = "F",
        color = R.color.invoice_status
    ),
    PEDIDO_CANCELADO_ERP(
        R.string.cancelado_pedido,
        charCaption = "C",
        color = R.color.cancel_status
    ),
    ORCAMENTO(R.string.orcamento, charCaption = "O", color = R.color.blue_color_es);

    companion object {
        fun requestType(typeRequest: String): CaptionsType {
            for (captions in values()) {
                return if (ORCAMENTO.name == typeRequest) {
                    ORCAMENTO
                } else {
                    PEDIDO_PENDENTE_ERP
                }
            }
            return EM_PROCESSAMENTO_PEDIDO
        }
    }
}