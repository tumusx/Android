package com.github.tumusx.maxappmvvm.clients.dataClients.domain.model

import com.github.tumusx.maxappmvvm.clients.dataClients.domain.fake.ClientDTOFake
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.fake.ContactsDTOFake
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class ClientDTOTest {
    private lateinit var clientDTO: ClientDTOFake
    private lateinit var contactDTOFake: ContactsDTOFake

    @Before
    fun setup() {
        contactDTOFake = ContactsDTOFake(
            "6299111",
            "Maria Isabel",
            "11-12-2001",
            "11-12-2001",
            "murillo@alves.com",
            "Murillo",
            "62993",
            "flamengo",
            "SOCIO"
        )
        clientDTO = ClientDTOFake(
            "11111",
            "1",
            listOf(contactDTOFake),
            "RS42",
            2,
            "maximatech",
            "maximatech ponto com",
            "Informatica",
            "Ativo"
        )
    }


    @Test
    fun verifyNameClient() {
        assertEquals(clientDTO.nomeFantasia, "maximatech")
    }

    @Test
    fun whenEmptyListReturnFalse() {
        assertEquals(clientDTO.contatos.isEmpty(), false)
    }

    @Test
    fun verifyValuesContacts() {
        assertEquals(
            clientDTO.contatos, listOf(
                ContactsDTOFake(
                    "6299111",
                    "Maria Isabel",
                    "11-12-2001",
                    "11-12-2001",
                    "murillo@alves.com",
                    "Murillo",
                    "62993",
                    "flamengo",
                    "SOCIO"
                )
            )
        )
    }

}