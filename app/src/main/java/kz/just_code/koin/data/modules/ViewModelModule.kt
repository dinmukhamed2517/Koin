package kz.just_code.koin.data.modules

import kz.just_code.koin.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(
            getMovieByYear = get(),
            searchMovie = get(),
            repository = get()
        )
    }
}