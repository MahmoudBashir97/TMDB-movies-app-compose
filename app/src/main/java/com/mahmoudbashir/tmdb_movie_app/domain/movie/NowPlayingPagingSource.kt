package com.mahmoudbashir.tmdb_movie_app.domain.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mahmoudbashir.tmdb_movie_app.data.MovieDetail
import kotlinx.coroutines.delay

class NowPlayingPagingSource(
    private val moviesService: MoviesService
) : PagingSource<Int, MovieDetail>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDetail> {
        return try {
            val currentPage = params.key ?: 1
            val response = moviesService.getNowPlaying(currentPage)
            delay(2000)
            LoadResult.Page(
                data = response.results!!,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.results.isEmpty()) null else currentPage + 1
            )
        } catch (t: Throwable) {
            LoadResult.Error(t)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieDetail>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}