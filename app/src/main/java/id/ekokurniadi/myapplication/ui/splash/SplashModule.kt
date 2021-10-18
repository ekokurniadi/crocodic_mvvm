package id.ekokurniadi.myapplication.ui.splash

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ekokurniadi.myapplication.injection.anotation.ViewModelKey


@Module
abstract class SplashModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindViewModel(viewModel: SplashViewModel):ViewModel
}