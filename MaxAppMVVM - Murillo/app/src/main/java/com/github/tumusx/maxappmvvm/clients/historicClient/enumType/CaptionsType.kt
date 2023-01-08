package com.github.tumusx.maxappmvvm.clients.historicClient.enumType

import com.github.tumusx.maxappmvvm.R

enum class CaptionsType(val descriptionCaption: Int,  val drawable: Int? = null, val charCaption: String = "") {
    EM_PROCESSAMENTO_PEDIDO(R.string.processamento_status, R.drawable.ic_maxima_em_processamento),
    PEDIDO_RECUSADO_ERP(R.string.recusado_status, charCaption = "!"),
    PEDIDO_PENDENTE_ERP(R.string.pendente_status, charCaption = "P"),
    PEDIDO_BLOQUEADO_ERP(R.string.bloqueado_status, charCaption = "B"),
    PEDIDO_LIBERADO_ERP(R.string.liberado_status, charCaption = "L"),
    PEDIDO_MONTADO_ERP(R.string.montado_status, charCaption = "M"),
    PEDIDO_FATURADO_ERP(R.string.faturado_status, charCaption = "F"),
    PEDIDO_CANCELADO_ERP(R.string.cancelado_pedido, charCaption = "C"),
    ORCAMENTO(R.string.orcamento, charCaption = "O");
}