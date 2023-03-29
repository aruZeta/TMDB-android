package com.aruzeta.tmdb.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aruzeta.tmdb.ui.screen.homeScreen.HomeScreen
import com.aruzeta.tmdb.ui.utils.Destination
import com.aruzeta.tmdb.ui.theme.TMDBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TMDBTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Destination.HomeScreen.route,
            ) {
                HomeScreen(navController)
            }
        } }
    }
}
