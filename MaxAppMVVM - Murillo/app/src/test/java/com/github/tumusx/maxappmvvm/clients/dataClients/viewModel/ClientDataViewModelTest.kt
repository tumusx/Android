package com.github.tumusx.maxappmvvm.clients.dataClients.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import baseTest.MainCoroutineRule
import com.github.tumusx.maxappmvvm.clients.dataClients.presenter.viewModel.ClientDataViewModel
import com.github.tumusx.maxappmvvm.clients.dataClients.repository.ClientFakeRepository
import com.github.tumusx.maxappmvvm.clients.dataClients.repository.ClientFakeRepository.Companion.clientDTO
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ClientDataViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineScope = MainCoroutineRule()

    private lateinit var viewModel: ClientDataViewModel

    @Before
    fun setup() {
        viewModel = ClientDataViewModel(ClientFakeRepository(false), Dispatchers.Main)
    }

    @Test
    fun searchDataClientReturnSuccess() {
        viewModel.searchClientRemote()
        assertEquals(viewModel.stateUI.value, StateUI.Success(clientDTO))
    }

    @Test
    fun searchDataClientReturnError() {
        viewModel.searchClientRemote()
        assertEquals(viewModel.stateUI.value, StateUI.Error("ERRO"))
    }
}