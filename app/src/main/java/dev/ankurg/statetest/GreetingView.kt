package dev.ankurg.statetest

interface GreetingView {
    fun render(state: GreetingState) {
        when(state.fetchStatus){
            FetchStatus.Loading -> showProgress(true)
            FetchStatus.Failure -> {
                showProgress(false)
                showError(state.error)
            }
        }
    }

    fun showProgress(show: Boolean)
    fun showError(error: String?)
}
