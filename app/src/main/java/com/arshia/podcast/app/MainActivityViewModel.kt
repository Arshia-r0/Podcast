package com.arshia.podcast.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arshia.podcast.core.data.userdata.UserDataRepositoryImp
import com.arshia.podcast.core.model.UserData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainActivityViewModel(
    userDataRepositoryImp: UserDataRepositoryImp,
): ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = userDataRepositoryImp.userData.map {
        MainActivityUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )

}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val data: UserData) : MainActivityUiState
}
