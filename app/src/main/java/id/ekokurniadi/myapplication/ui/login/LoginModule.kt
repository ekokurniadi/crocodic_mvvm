package id.ekokurniadi.myapplication.ui.login

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ekokurniadi.myapplication.injection.anotation.ViewModelKey


@Module
abstract class LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindViewModel(viewModel: LoginViewModel):ViewModel
}