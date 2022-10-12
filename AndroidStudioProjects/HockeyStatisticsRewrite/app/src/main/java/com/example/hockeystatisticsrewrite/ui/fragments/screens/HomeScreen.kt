package com.example.hockeystatisticsrewrite.ui.fragments.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hockeystatisticsrewrite.ui.fragments.composables.UserFavorites

@Composable
fun HomeScreen(padding: Modifier) {
    PageBody()
}
@Composable
fun PageBody() {
    UserFavorites()
}