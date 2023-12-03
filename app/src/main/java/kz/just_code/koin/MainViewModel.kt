package kz.just_code.koin

import android.graphics.Movie
import androidx.lifecycle.LiveData
import kz.just_code.hilt.base.BaseViewModel
import kz.just_code.hilt.data.network.MovieResponse
import kz.just_code.hilt.data.repositories.MovieRepository
import kz.just_code.hilt.data.useCases.GetMovieByYearUseCase
import kz.just_code.hilt.data.useCases.SearchMovieUseCase

class MainViewModel(
    private val getMovieByYear : GetMovieByYearUseCase,
    private val searchMovie: SearchMovieUseCase,
    private val repository: MovieRepository
): BaseViewModel() {

    val movies: LiveData<List<MovieResponse>> = repository.movies

    fun getMovieByYear(year: Int) {
        launch(
            request = {
                getMovieByYear.execute(year)
            }
        )
    }
}

