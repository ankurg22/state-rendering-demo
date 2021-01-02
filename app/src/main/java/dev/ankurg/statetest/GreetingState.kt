package dev.ankurg.statetest

import java.lang.Exception

data class GreetingState(
    val fetchStatus: FetchStatus,
    val greeting: String? = null,
    val error: String? = null
)

sealed class FetchStatus {
    object Loading : FetchStatus()
    object Success : FetchStatus()
    object Failure : FetchStatus()
}