package com.github.tumusx.maxappmvvm.clients.historicClient.data.repository

import com.github.tumusx.core_database.database.AppDatabase
import com.github.tumusx.core_database.entitys.HistoricEntity
import com.github.tumusx.core_database.entitys.PedidoEntity
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.Pedido
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricLocalRepository

class HistoricLocalRepositoryImpl(private val appDatabase: AppDatabase) : IHistoricLocalRepository {


    private fun mapperHistoricToEntity(historic: List<Pedido>): HistoricEntity {
        return HistoricEntity(pedidoEntity = historic.map { pedidoItem ->
            PedidoEntity(
                nameClient = pedidoItem.nomeClient,
                codeClient = pedidoItem.codigoCliente,
                review = pedidoItem.critica,
                data = pedidoItem.data,
                numberRequestERP = pedidoItem.numeroPedErp,
                numberRequestRCA = pedidoItem.numeroPedRca,
                status = pedidoItem.status,
                type = pedidoItem.tipo
            )
        })
    }

    private fun mapperEntityToHistoricList(historicEntity: List<PedidoEntity>): List<Pedido> {
        return historicEntity.map { historic ->
            Pedido(
                historic.nameClient,
                historic.codeClient,
                historic.review,
                historic.data,
                emptyList(),
                historic.numberRequestRCA,
                historic.numberRequestERP,
                historic.status,
                historic.type
            )
        }
    }


    override suspend fun getHistoric(): List<Pedido>? {
        val resultDaBase = appDatabase.historicDAO().getHistoric()
        return try {
            mapperEntityToHistoricList(resultDaBase.pedidoEntity)
        } catch (exception: Exception) {
            exception.printStackTrace()
            emptyList()
        }
    }

    override suspend fun insertHistoric(historic: HistoricDTO) {
        try {
            appDatabase.historicDAO().insertHistoric(mapperHistoricToEntity(historic.request))
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}