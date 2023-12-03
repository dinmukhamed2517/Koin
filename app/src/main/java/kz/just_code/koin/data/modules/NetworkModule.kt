package kz.just_code.koin.data.modules

import kz.just_code.hilt.data.network.MovieApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        getRetrofit()
    }
    single {
        getMovieApi(get())
    }
}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.movieapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun getMovieApi(retrofit: Retrofit): MovieApi {
    return retrofit.create(MovieApi::class.java)
}

