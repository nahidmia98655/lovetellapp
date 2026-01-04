package com.example.lovetell.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lovetell.ui.screens.DetailScreen
import com.example.lovetell.ui.screens.HomeScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(onStoryClick = { storyId ->
                navController.navigate("detail/$storyId")
            })
        }
        composable(
            route = "detail/{storyId}",
            arguments = listOf(navArgument("storyId") { type = NavType.IntType })
        ) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getInt("storyId") ?: 0
            DetailScreen(storyId = storyId, onBack = { navController.popBackStack() })
        }
    }
}
