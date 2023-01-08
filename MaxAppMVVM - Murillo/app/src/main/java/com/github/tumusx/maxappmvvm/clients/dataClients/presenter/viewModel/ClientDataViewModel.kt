package com.github.tumusx.maxappmvvm.clients.dataClients.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientDataViewModel @Inject constructor(
    private val clientDataRepository: IClientDataRepository) : ViewModel() {
    private val _stateUI: MutableLiveData<StateUI> = MutableLiveData(StateUI.IsLoading)
    val stateUI: LiveData<StateUI> = _stateUI

    init {
        searchClientRemote()
    }

    private fun searchClientRemote() {
        viewModelScope.launch(Dispatchers.IO) {
            val clientResponse = clientDataRepository.getDataClient()
            if (clientResponse is ApiResult.Success) {
                clientResponse.data?.let { clientData ->
                    _stateUI.postValue(StateUI.Success(clientData))
                }
            } else {
                _stateUI.postValue(
                    StateUI.Error(
                        (clientResponse as ApiResult.Error).messageError ?: "ERROR"
                    )
                )
            }
        }
    }
}