package id.ekokurniadi.myapplication.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.ui.base.BaseActivity
import id.ekokurniadi.myapplication.ui.form.list.VisitListActivity

class LoginActivity : BaseActivity<LoginViewModel>() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        observeData()

        inputEmail = findViewById(R.id.input_email)
        inputPassword = findViewById(R.id.input_password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            viewModel.login(email, password)
        }
    }

    private fun observeData() {
        viewModel.userNotifier.observe(this, Observer{
            if (!it.isNullOrEmpty()) {

                val dialogWelcome = DialogWelcomeFragment(it) {
                    val formIntent = Intent(this, VisitListActivity::class.java)
                    startActivity(formIntent)
                    finish()
                }

                dialogWelcome.show(supportFragmentManager, "login")
            }
        })
    }
}