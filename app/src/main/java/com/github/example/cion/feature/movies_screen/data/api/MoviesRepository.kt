package com.github.example.cion.feature.movies_screen.data.api

import com.github.example.cion.feature.movies_screen.domain.model.Movie

interface MoviesRepository {
    suspend fun fetchMovies(): List<Movie>
}