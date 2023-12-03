package kz.just_code.hilt.data.modules

import kz.just_code.hilt.data.useCases.provideGetMovieByNameUseCase
import kz.just_code.hilt.data.useCases.provideSearchMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        provideGetMovieByNameUseCase(get())
    }
    factory {
        provideSearchMovieUseCase(get())
    }
}