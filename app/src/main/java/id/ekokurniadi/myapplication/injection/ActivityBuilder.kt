package id.ekokurniadi.myapplication.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ekokurniadi.myapplication.ui.splash.SplashActivity
import id.ekokurniadi.myapplication.ui.splash.SplashModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindSplashActivity(): SplashActivity
}