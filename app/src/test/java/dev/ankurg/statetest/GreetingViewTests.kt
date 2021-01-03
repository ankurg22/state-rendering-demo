package dev.ankurg.statetest

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
    }
}
