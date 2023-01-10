package com.github.tumusx.maxappmvvm.clients.dataClients.data.repository

import com.github.tumusx.core_database.database.AppDatabase
import com.github.tumusx.core_database.entitys.ClientEntity
import com.github.tumusx.core_database.entitys.ContactEntity
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.Contato
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataLocalRepository

class ClientLocalRepositoryImpl(private val appDatabase: AppDatabase) : IClientDataLocalRepository {

    private fun contactListMapper(contactList: List<ContactEntity>): List<Contato> {
        return try {
            contactList.map { itemContact ->
                Contato(
                    itemContact.celular,
                    itemContact.conjuge,
                    itemContact.bithClientConjuge,
                    itemContact.bithClient,
                    itemContact.email,
                    itemContact.nome,
                    itemContact.telefone,
                    itemContact.time,
                    itemContact.tipo
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getDataClientLocalDatabase(): ClientDTO? {
        val responseResult = appDatabase.clientDAO().pegarClients()
        return try {
            ClientDTO(
                responseResult.cnpj,
                responseResult.code,
                contactListMapper(responseResult.contact),
                responseResult.address,
                responseResult.id, responseResult.fantasyName, responseResult.activityClient,
                responseResult.companyName,
                responseResult.status
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

    private fun contactClientMapper(contacts: List<Contato>): List<ContactEntity> {
        return try {
            contacts.map { contact ->
                ContactEntity(
                    celular = contact.celular,
                    conjuge = contact.conjuge,
                    bithClientConjuge = contact.dataNascimentoConjuge ?: "-",
                    bithClient = contact.dataNascimento,
                    email = contact.e_mail,
                    nome = contact.nome,
                    telefone = contact.telefone,
                    time = contact.time,
                    tipo = contact.tipo
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            emptyList()
        }
    }

    override suspend fun insertDataClientLocalDatabase(clientDTO: ClientDTO) {
        try {
            appDatabase.clientDAO().insertClient(
                    ClientEntity(
                        cnpj = clientDTO.cnpj,
                        code = clientDTO.codigo,
                        contact = contactClientMapper(clientDTO.contatos),
                        address = clientDTO.endereco,
                        id = clientDTO.id,
                        fantasyName = clientDTO.nomeFantasia,
                        activityClient = clientDTO.ramoAtividade,
                        companyName = clientDTO.ramoAtividade,
                        status = clientDTO.status
                    )
                )
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}