package com.github.tumusx.maxappmvvm.clients.dataClients.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.di.IoDispatcher
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class ClientDataViewModel @Inject constructor(
    private val clientDataRepository: IClientDataRepository,
    @IoDispatcher private val coroutineContext: CoroutineDispatcher
) : ViewModel() {
    private val _stateUI: MutableLiveData<StateUI> = MutableLiveData(StateUI.IsLoading)
    val stateUI: LiveData<StateUI> = _stateUI

     fun searchClientRemote() {
        viewModelScope.launch(coroutineContext) {
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