package id.ekokurniadi.myapplication.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.ui.base.BaseActivity

class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
