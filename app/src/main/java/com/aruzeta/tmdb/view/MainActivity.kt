package com.aruzeta.tmdb.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aruzeta.tmdb.BuildConfig
import com.aruzeta.tmdb.ui.Destination
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
                startDestination = Destination.FirstScreen.route,
            ) {
                composable(Destination.FirstScreen.route) {
                    Text(text = "Hello world")
                    Text(text = "Api key: ${BuildConfig.TMDB_API_KEY}")
                }
            }
        } }
    }
}
