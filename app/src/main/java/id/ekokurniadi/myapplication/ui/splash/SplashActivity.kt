package id.ekokurniadi.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.ui.base.BaseActivity
import id.ekokurniadi.myapplication.ui.form.input.FormInputActivity
import id.ekokurniadi.myapplication.ui.form.list.VisitListActivity
import id.ekokurniadi.myapplication.ui.login.LoginActivity


class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycle.addObserver(viewModel)
        observeData()
        viewModel.checkToken()
    }

    private fun observeData() {
        viewModel.splashNotifier.observe(this, Observer{
            if (it) {
                val formIntent = Intent(this, LoginActivity::class.java)
                startActivity(formIntent)
                finish()
            }
        })
    }
}
