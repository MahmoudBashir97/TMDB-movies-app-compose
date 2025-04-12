package com.mahmoudbashir.tmdb_movie_app.domain.movie

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mahmoudbashir.tmdb_movie_app.data.GetPopularMoviesResponse
import com.mahmoudbashir.tmdb_movie_app.data.GetUpComingResponse
import com.mahmoudbashir.tmdb_movie_app.data.MovieDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataSource @Inject constructor(
    private val apiService: MoviesService
) : MoviesService {
    override suspend fun getUpComingMovies(): GetUpComingResponse {
        return apiService.getUpComingMovies()
    }

    override suspend fun getNowPlaying(page: Int): GetUpComingResponse {
        return apiService.getNowPlaying(page)
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return apiService.getMovieDetail(id)
    }

    override fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>> {
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 5, initialLoadSize = 1),
            pagingSourceFactory = { NowPlayingPagingSource(apiService) }
        ).flow
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        return apiService.getMoviePopular()
    }
}