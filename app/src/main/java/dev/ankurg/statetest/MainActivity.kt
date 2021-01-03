package dev.ankurg.statetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GreetingView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(error: String?) {
        errorTextView.visibility = View.VISIBLE
        errorTextView.text = error
    }

    override fun showGreeting(greeting: String?) {
        greetingTextView.visibility = View.VISIBLE
        greetingTextView.text = greeting
    }
}
