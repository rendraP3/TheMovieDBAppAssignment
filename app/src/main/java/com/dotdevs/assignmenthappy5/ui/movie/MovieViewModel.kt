package com.dotdevs.assignmenthappy5.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dotdevs.assignmenthappy5.model.dto.error.ErrorDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.network.NetworkHelper
import com.dotdevs.assignmenthappy5.network.api.movie.repository.MovieListRepository
import com.dotdevs.assignmenthappy5.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository,
    networkHelper: NetworkHelper
) : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<Resource<MovieListDto>>()
    private val _topRatedMovies = MutableLiveData<Resource<MovieListDto>>()
    private val _popularMovies = MutableLiveData<Resource<MovieListDto>>()
    private val _upcomingMovies = MutableLiveData<Resource<MovieListDto>>()
    private val _errorMessage = MutableLiveData<Resource<ErrorDto>>()

    val nowPlayingMovies : LiveData<Resource<MovieListDto>> = _nowPlayingMovies
    val topRatedMovies : LiveData<Resource<MovieListDto>> = _topRatedMovies
    val popularMovies : LiveData<Resource<MovieListDto>> = _popularMovies
    val upcomingMovies : LiveData<Resource<MovieListDto>> = _upcomingMovies
    val errorMessage : LiveData<Resource<ErrorDto>> = _errorMessage

    init {
        _errorMessage.postValue(Resource.loading(null))

        if (networkHelper.isNetworkConnected()) {
            fetchNowPlayingMovies()
            fetchPopularMovies()
            fetchTopRatedMovies()
            fetchUpcomingMovies()
        } else {
            _errorMessage.postValue(
                Resource.error(
                    data = null,
                    message = "Please check your internet connection"
                )
            )
        }
    }

    private fun fetchNowPlayingMovies() {
        viewModelScope.launch {
            try {
                _nowPlayingMovies.value = Resource.success(
                    data = movieListRepository.getPlayingMovieList()
                )
            } catch (e: Exception) {
                _errorMessage.value = Resource.error(
                    data = null,
                    message = e.message ?: "Unknown Error"
                )
            }
        }
    }

    private fun fetchTopRatedMovies() {
        viewModelScope.launch {
            try {
                _topRatedMovies.value = Resource.success(
                    data = movieListRepository.getTopRatedMovieList()
                )
            } catch (e: Exception) {
                _errorMessage.value = Resource.error(
                    data = null,
                    message = e.message ?: "Unknown Error"
                )
            }
        }
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                _popularMovies.value = Resource.success(
                    data = movieListRepository.getPopularMovieList()
                )
            } catch (e: Exception) {
                _errorMessage.value = Resource.error(
                    data = null,
                    message = e.message ?: "Unknown Error"
                )
            }
        }
    }

    private fun fetchUpcomingMovies() {
        viewModelScope.launch {
            try {
                _upcomingMovies.value = Resource.success(
                    data = movieListRepository.getUpcomingMovieList()
                )
            } catch (e: Exception) {
                _errorMessage.value = Resource.error(
                    data = null,
                    message = e.message ?: "Unknown Error"
                )
            }
        }
    }

}