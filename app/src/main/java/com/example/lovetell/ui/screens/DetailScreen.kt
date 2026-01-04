package com.example.lovetell.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lovetell.viewmodel.MainViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@Composable
fun DetailScreen(
    storyId: Int,
    onBack: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val story = viewModel.getStoryById(storyId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(story?.title ?: "Story") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = story?.content ?: "No content",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
