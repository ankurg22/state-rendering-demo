package dev.ankurg.statetest

interface GreetingView {
    fun render(state: GreetingState) {
        showProgress(true)
    }

    fun showProgress(show: Boolean)
}
