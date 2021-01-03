package dev.ankurg.statetest

open class SpyableGreetingView : GreetingView {
    override fun showProgress(show: Boolean) {}
    override fun showError(error: String?) {}
    override fun showGreeting(greeting: String?) {}
}