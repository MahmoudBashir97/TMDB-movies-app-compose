package com.mahmoudbashir.tmdb_movie_app.domain.movie

import androidx.paging.PagingData
import com.mahmoudbashir.tmdb_movie_app.data.GetPopularMoviesResponse
import com.mahmoudbashir.tmdb_movie_app.data.GetUpComingResponse
import com.mahmoudbashir.tmdb_movie_app.data.MovieDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesService {

    @GET("movie/upcoming")
    suspend fun getUpComingMovies():GetUpComingResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page:Int): GetUpComingResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Int): MovieDetail

    @GET("movie/popular")
    suspend fun getMoviePopular(): GetPopularMoviesResponse

    fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>>


}