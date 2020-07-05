package com.example.iddogs.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hearthstone.R

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var loadingLayout: View? = null
    private lateinit var rootLayout: ViewGroup

    override fun showLoading() = runOnUiThread {
        disableTouch()
        hideKeyboard()
        createLoading()
    }

    override fun hideLoading() = runOnUiThread {
        enableTouch()
        removeLoading()
    }

    private fun disableTouch() = runOnUiThread {
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    private fun enableTouch() = runOnUiThread {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    private fun hideKeyboard() = runOnUiThread {
        val view = if (currentFocus != null) currentFocus else View(this)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    private fun createLoading() = runOnUiThread {
        if (loadingLayout == null) {
            rootLayout = findViewById<View>(android.R.id.content) as ViewGroup
            val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            loadingLayout = layoutInflater.inflate(R.layout.activity_loading, rootLayout, true)
        }
    }

    private fun removeLoading() = runOnUiThread {
        if (loadingLayout != null) {
            val loading = rootLayout.findViewById<View>(R.id.loader)
            rootLayout.removeView(loading)
            loadingLayout = null
        }
    }

    override fun showGenericError() {
        Toast.makeText(this, getString(R.string.generic_error), Toast.LENGTH_SHORT).show()
    }

}