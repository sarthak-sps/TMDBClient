package com.example.tmdbclient.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase:UpdateMoviesUsecase
) : ViewModel() {

    fun getMovies()= liveData {
        val movieList= getMoviesUseCase.execute()
        emit(movieList)
    }

    fun  updateMovie()= liveData {
        val movieList= updateMoviesUseCase.execute()
        emit(movieList)
    }

}