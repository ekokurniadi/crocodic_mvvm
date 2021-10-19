package id.ekokurniadi.myapplication.ui.form.list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ekokurniadi.myapplication.injection.anotation.ViewModelKey


@Module
abstract class VisitListModule {
    @Binds
    @IntoMap
    @ViewModelKey(VisitListViewModel::class)
    abstract fun bindViewModel(viewModel: VisitListViewModel): ViewModel
}