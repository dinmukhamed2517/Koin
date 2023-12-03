package kz.just_code.hilt.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import kz.just_code.hilt.data.network.MovieApi
import kz.just_code.hilt.data.network.MovieApiError
import kz.just_code.hilt.data.network.MovieResponse
import okhttp3.ResponseBody

interface MovieRepository {
    suspend fun getMovieByYear(year:Int):MovieResponse?
    suspend fun searchMovie(name:String):MovieResponse?
    val movies: LiveData<List<MovieResponse>>

}


class MovieRepositoryImpl(
    private val api:MovieApi,

    ):MovieRepository{
    override var movies = MutableLiveData<List<MovieResponse>>()
    override suspend fun getMovieByYear(year: Int): MovieResponse? {
        val response = api.getMoviesByYear(year)
        if(response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun searchMovie(name: String): MovieResponse? {
        val response = api.searchMovie(name)
        if(response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

}

fun ResponseBody?.getErrorMessage(): String? {
    return try {
        Gson().fromJson(this?.charStream(), MovieApiError::class.java)?.error?.message
    } catch (e: Exception) {
        e.message.orEmpty()
    }
}

fun provideMovieRepository(api:MovieApi):MovieRepository = MovieRepositoryImpl(api)