package com.arshia.podcast.core.model

import kotlinx.serialization.Serializable

@Serializable
data class PlayerState(
    val currentEpisode: Episode? = null,
    val currentBook: Book? = null,
    val position: Long = 0,
)
