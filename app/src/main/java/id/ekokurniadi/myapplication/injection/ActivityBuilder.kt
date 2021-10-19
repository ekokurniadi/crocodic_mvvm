package id.ekokurniadi.myapplication.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ekokurniadi.myapplication.ui.form.input.FormInputActivity
import id.ekokurniadi.myapplication.ui.form.input.FormInputModule
import id.ekokurniadi.myapplication.ui.form.output.FormOutputActivity
import id.ekokurniadi.myapplication.ui.form.output.FormOutputModule
import id.ekokurniadi.myapplication.ui.splash.SplashActivity
import id.ekokurniadi.myapplication.ui.splash.SplashModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [FormInputModule::class])
    abstract fun bindFormInputActivity(): FormInputActivity

    @ContributesAndroidInjector(modules = [FormOutputModule::class])
    abstract fun bindFormOutputActivity(): FormOutputActivity

}