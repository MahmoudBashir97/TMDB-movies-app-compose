package com.mahmoudbashir.tmdb_movie_app.domain.movie

import androidx.paging.PagingData
import com.mahmoudbashir.tmdb_movie_app.data.GetPopularMoviesResponse
import com.mahmoudbashir.tmdb_movie_app.data.GetUpComingResponse
import com.mahmoudbashir.tmdb_movie_app.data.MovieDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataSource: DataSource
) : MoviesService {

    override suspend fun getUpComingMovies(): GetUpComingResponse {
        return dataSource.getUpComingMovies()
    }

    override suspend fun getNowPlaying(page: Int): GetUpComingResponse {
        return dataSource.getNowPlaying(page)
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return dataSource.getMovieDetail(id)
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        return dataSource.getMoviePopular()
    }

    override fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>> {
        return dataSource.getNowPlayingPagingFlow()
    }
}