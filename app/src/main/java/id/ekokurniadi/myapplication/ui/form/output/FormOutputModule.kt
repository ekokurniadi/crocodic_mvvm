package id.ekokurniadi.myapplication.ui.form.output

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ekokurniadi.myapplication.injection.anotation.ViewModelKey


@Module
abstract class FormOutputModule {
    @Binds
    @IntoMap
    @ViewModelKey(FormOutputViewModel::class)
    abstract fun bindViewModel(viewModel: FormOutputViewModel):ViewModel
}