package kz.just_code.koin.data.modules

import kz.just_code.hilt.data.repositories.provideMovieRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { provideMovieRepository(api = get()) }
}
