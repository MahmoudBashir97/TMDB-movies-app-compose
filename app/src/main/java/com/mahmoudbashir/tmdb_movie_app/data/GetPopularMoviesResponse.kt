package com.mahmoudbashir.tmdb_movie_app.data

import com.google.gson.annotations.SerializedName

data class GetPopularMoviesResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieDetail?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)