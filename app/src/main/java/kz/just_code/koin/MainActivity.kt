package kz.just_code.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.just_code.koin.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMovieByYear(1999)
        viewModel.movies.observe(this){

        }
    }
}