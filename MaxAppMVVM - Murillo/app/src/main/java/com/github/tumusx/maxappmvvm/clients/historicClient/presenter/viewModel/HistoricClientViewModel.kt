package com.github.tumusx.maxappmvvm.clients.historicClient.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricRepository
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoricClientViewModel @Inject constructor(
    private val historicClientRepository: IHistoricRepository
) : ViewModel() {
    private val _stateUI: MutableLiveData<StateUI> = MutableLiveData(StateUI.IsLoading)
    val stateUI: LiveData<StateUI> = _stateUI

    init {
        searchHistoricResponse()
    }

    private fun searchHistoricResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            val historicResponse = historicClientRepository.searchHistoricClient()
            if (historicResponse is ApiResult.Success) {
                historicResponse.data?.let { result ->
                    _stateUI.postValue(StateUI.Success(result.request))
                }
            } else {
                _stateUI.postValue(
                    StateUI.Error(
                        (historicResponse as ApiResult.Error).messageError ?: "ERROR"
                    )
                )
            }
        }
    }
}