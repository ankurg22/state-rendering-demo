package dev.ankurg.statetest

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import java.net.SocketException

@RunWith(MockitoJUnitRunner::class)
class GreetingViewTests {
    @Spy
    private lateinit var view: SpyableGreetingView

    @Test
    fun `greeting fetch in progress and user sees progress bar`() {
        // Setup
        val loadingState = GreetingState(
            fetchStatus = FetchStatus.Loading,
            greeting = null,
            error = null
        )

        // Act
        view.render(loadingState)

        // Assert
        verify(view).showProgress(true)
        verify(view, never()).showError(any())
        verify(view, never()).showGreeting(any())
    }

    @Test
    fun `greeting fetch failed with an error`() {
        // Setup
        val error = SocketException().message
        val errorState = GreetingState(
            fetchStatus = FetchStatus.Failure,
            greeting = null,
            error = error
        )

        // Act
        view.render(errorState)

        // Assert
        verify(view).showProgress(false)
        verify(view).showError(error)
        verify(view, never()).showGreeting(any())
    }

    @Test
    fun `greeting fetched successfully and shown to user`() {
        // Setup
        val greeting = "Hello Android Wizard"
        val successState = GreetingState(
            fetchStatus = FetchStatus.Success,
            greeting = greeting,
            error = null
        )

        // Act
        view.render(successState)

        // Assert
        verify(view).showProgress(false)
        verify(view).showGreeting(greeting)
        verify(view, never()).showError(any())
    }
}
