package com.github.tumusx.maxappmvvm.clients.dataClients.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.di.IoDispatcher
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataLocalRepository
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import com.github.tumusx.maxappmvvm.commons.stateUI.StateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientDataViewModel @Inject constructor(
    private val clientDataRepository: IClientDataRepository,
    @IoDispatcher private val coroutineContext: CoroutineDispatcher,
    private val clientLocalRepository: IClientDataLocalRepository
) : ViewModel() {
    private val _stateUI: MutableLiveData<StateUI> = MutableLiveData(StateUI.IsLoading)
    val stateUI: LiveData<StateUI> = _stateUI


    private fun insertClientInDataBase(clientDTO: ClientDTO) {
        viewModelScope.launch(coroutineContext) {
            try {
                clientLocalRepository.insertDataClientLocalDatabase(clientDTO)
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    fun readClientInDataBase() {
        viewModelScope.launch(coroutineContext) {
            val responseDatabaseClients = clientLocalRepository.getDataClientLocalDatabase()
            try {
                if(responseDatabaseClients == null) {
                    _stateUI.postValue(StateUI.Error("Ops! Sem informações! Tente conectar na internet primeiro."))
                    return@launch
                }
                _stateUI.postValue(StateUI.Success(responseDatabaseClients))
                println(responseDatabaseClients)
            } catch (exception: Exception) {
                exception.printStackTrace()
                _stateUI.postValue(StateUI.Error("ERROR"))
            }
        }
    }

    fun searchClientRemote() {
        viewModelScope.launch(coroutineContext) {
            val clientResponse = clientDataRepository.getDataClient()
            if (clientResponse is ApiResult.Success) {
                clientResponse.data?.let { clientData ->
                    insertClientInDataBase(clientData)
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