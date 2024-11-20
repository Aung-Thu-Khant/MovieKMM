package org.example.moviekmm.model

import org.jetbrains.compose.resources.DrawableResource

data class MovieData(
    val title: String,
    val description: String,
    val imageRes: DrawableResource
)
