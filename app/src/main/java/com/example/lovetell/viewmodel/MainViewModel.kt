package com.example.lovetell.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// Simple data class representing a love story
data class Story(
    val id: Int,
    val title: String,
    val preview: String,
    val content: String
)

class MainViewModel : ViewModel() {

    // Sample stories for demonstration purposes
    private val _storyList = MutableStateFlow(
        listOf(
            Story(
                id = 1,
                title = "First Love",
                preview = "A tale of first love that blossoms in spring...",
                content = "Once upon a time, in a small town..."
            ),
            Story(
                id = 2,
                title = "Eternal Promise",
                preview = "Two souls promising each other eternity...",
                content = "Under the stars, they whispered..."
            ),
            Story(
                id = 3,
                title = "Unexpected Reunion",
                preview = "Fate brings them together after years apart...",
                content = "She walked into the cafe and saw..."
            )
        )
    )

    val storyList: StateFlow<List<Story>> = _storyList

    // Helper to retrieve a story by its id
    fun getStoryById(id: Int): Story? = _storyList.value.find { it.id == id }
}
