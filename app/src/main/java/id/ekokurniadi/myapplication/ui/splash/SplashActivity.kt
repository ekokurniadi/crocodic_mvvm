package id.ekokurniadi.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.ui.base.BaseActivity
import id.ekokurniadi.myapplication.ui.form.input.FormInputActivity

class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycle.addObserver(viewModel)
        observeData()
        viewModel.delayCountDown(3000)
    }

    private fun observeData() {
        viewModel.splashNotifier.observe(this, Observer{ it ->
            if (it){
                val formIntent=Intent(this,FormInputActivity::class.java)
                startActivity(formIntent)
                finish()
            }
        })
    }
}
