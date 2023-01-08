package com.github.tumusx.maxappmvvm.commons.stateUI

sealed class StateUI {
    data class Success<T>(val data: T) : StateUI()
    data class Error(val messageError: String) : StateUI()
    object IsLoading : StateUI()
}