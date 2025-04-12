package com.mahmoudbashir.tmdb_movie_app.domain

import androidx.paging.PagingData
import com.mahmoudbashir.tmdb_movie_app.data.GetPopularMoviesResponse
import com.mahmoudbashir.tmdb_movie_app.data.GetUpComingResponse
import com.mahmoudbashir.tmdb_movie_app.data.MovieDetail
import com.mahmoudbashir.tmdb_movie_app.domain.movie.MoviesService
import com.mahmoudbashir.tmdb_movie_app.domain.movie.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repository: Repository
) : MoviesService {

    override suspend fun getUpComingMovies(): GetUpComingResponse {
        delay(1000)
        return repository.getUpComingMovies()
    }

    override suspend fun getNowPlaying(page: Int): GetUpComingResponse {
        delay(1000)
        return repository.getNowPlaying(page)
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        delay(1000)
        return repository.getMovieDetail(id)
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        delay(1000)
        return repository.getMoviePopular()
    }

    override fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>> {
        return repository.getNowPlayingPagingFlow()
    }
}