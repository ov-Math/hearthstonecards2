package com.example.hearthstone.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hearthstone.R
import com.example.iddogs.core.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : BaseActivity(), LoginView {

    private val presenter : LoginPresenter by inject { parametersOf(this) }

    override fun onBackPressed() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)

        presenter.checkForCachedUser()

        loginBtn.setOnClickListener {
            presenter.login(email.text.toString(), password.text.toString())
        }
    }

    override fun showLoginError() {
        Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show()
    }
}