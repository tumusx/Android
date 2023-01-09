package com.github.tumusx.maxappmvvm.enumType

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.tumusx.maxappmvvm.R
import com.github.tumusx.maxappmvvm.clients.historicClient.enumType.CaptionsUtils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CaptionsUtilsTest {
    private lateinit var captionsUtils: CaptionsUtils

    @Before
    fun setup() {
        captionsUtils = CaptionsUtils()
    }

    @Test
    fun captionCriticSuccess() {
        val caption = captionsUtils.pegarCritica("SUCESSO")
        assertEquals(caption, R.drawable.ic_maxima_critica_sucesso)
    }

    @Test
    fun captionAwaitReturnERP() {
        val caption = captionsUtils.pegarCritica("AGUARDANDO_RETORNO_ERP")
        assertEquals(caption, R.drawable.ic_maxima_aguardando_critica)
    }

    @Test
    fun captionFailParcial() {
        val caption = captionsUtils.pegarCritica("FALHA_PARCIAL")
        assertEquals(caption, R.drawable.ic_maxima_critica_alerta)
    }

    @Test
    fun captionTotalFail() {
        val caption = captionsUtils.pegarCritica("FALHA_TOTAL")
        assertEquals(caption, R.drawable.ic_error_alert)
    }


    @Test
    fun captionIconRepair() {
        val caption = captionsUtils.pegarLegendaIcone("PEDIDO_SOFREU_CORTE")
        assertEquals(caption, R.drawable.ic_maxima_legenda_corte)
    }

    @Test
    fun captionTelemarketing() {
        val caption = captionsUtils.pegarLegendaIcone("PEDIDO_FEITO_TELEMARKETING")
        assertEquals(caption, R.drawable.ic_maxima_legenda_telemarketing)
    }

    @Test
    fun captionCancelERP() {
        val caption = captionsUtils.pegarLegendaIcone("PEDIDO_CANCELADO_ERP")
        assertEquals(caption, R.drawable.ic_maxima_legenda_cancelamento)
    }
}