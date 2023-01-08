package com.github.tumusx.maxappmvvm.menu.enumType

import com.github.tumusx.maxappmvvm.R

enum class MenuTypes(val titleMenuType: Int, val imgTypeMenu: Int) {
    CLIENT(titleMenuType = R.string.cliente, imgTypeMenu = R.drawable.ic_maxima_pessoas),
    REQUEST(titleMenuType = R.string.pedidos, imgTypeMenu = R.drawable.ic_maxima_pedido),
    SALES_SUMMARY(titleMenuType = R.string.resumo_de_vendas, imgTypeMenu = R.drawable.ic_maxima_resumo_vendas),
    TOOLS(titleMenuType = R.string.ferramentas, imgTypeMenu = R.drawable.ic_maxima_ferramentas);

    companion object {
        fun menuTypes(): List<MenuTypes> {
            return mutableListOf(CLIENT, REQUEST, SALES_SUMMARY, TOOLS)
        }
    }
}