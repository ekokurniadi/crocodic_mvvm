package id.ekokurniadi.myapplication

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import id.ekokurniadi.myapplication.injection.DaggerAppComponent

class Core : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this).build()
    }
}