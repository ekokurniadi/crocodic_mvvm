package id.ekokurniadi.myapplication.ui.form.input

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ekokurniadi.myapplication.injection.anotation.ViewModelKey


@Module
abstract class FormInputModule {
    @Binds
    @IntoMap
    @ViewModelKey(FormInputViewModel::class)
    abstract fun bindViewModel(viewModel: FormInputViewModel):ViewModel
}