package com.example.hockeystatisticsrewrite.ui.fragments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hockeystatisticsrewrite.ui.fragments.composables.BottomBar
import com.example.hockeystatisticsrewrite.ui.fragments.screens.AccountScreen
import com.example.hockeystatisticsrewrite.ui.fragments.screens.HomeScreen
import com.example.hockeystatisticsrewrite.ui.fragments.screens.HubScreen
import com.example.hockeystatisticsrewrite.ui.fragments.screens.SettingsScreen
import com.example.hockeystatisticsrewrite.ui.theme.HockeyStatisticsRewriteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HockeyStatisticsRewriteTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = { BottomBar(navHostController = navController)},
                    content = { padding ->
                        NavHostContainer(navController = navController, padding = padding)
                    }
                )
            }
        }
    }
}
@Composable
fun NavHostContainer(navController:NavHostController, padding:PaddingValues){
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable("home"){
                HomeScreen(padding = Modifier.padding())
            }
            composable("hub"){
                HubScreen()
            }
            composable("settings"){
                SettingsScreen()
            }
            composable("account"){
                AccountScreen()
            }
        }
    )
}