package com.github.tumusx.maxappmvvm.clients.historicClient.presenter.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import baseTest.MainCoroutineRule
import com.github.tumusx.maxappmvvm.clients.dataClients.repository.ClientFakeRepository
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import com.github.tumusx.maxappmvvm.clients.historicClients.HistoricFakeRepository
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HistoricClientViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineScope = MainCoroutineRule()

    private lateinit var viewModel: HistoricClientViewModel

    @Before
    fun setup() {
        viewModel = HistoricClientViewModel(HistoricFakeRepository(true))
    }

    @Test
    fun searchHistoricSuccess() {
        viewModel.searchHistoricResponse()
        Assert.assertEquals(
            viewModel.stateUI.value,
            StateUI.Success(HistoricFakeRepository.listRequest)
        )
    }

    @Test
    fun searchDataClientReturnError() {
        viewModel.searchHistoricResponse()
        Assert.assertEquals(viewModel.stateUI.value, StateUI.Error("ERROR"))
    }
}