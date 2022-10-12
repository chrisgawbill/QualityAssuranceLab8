package com.example.hockeystatisticsrewrite.ui.fragments.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var favoriteTeams =
    listOf("Philadelphia Flyers", "Pittsburgh Penguins", "Los Angeles Kings")
var favoritePlayers = listOf("Claude Giroux", "Sidney Crosby", "Anze Kopitar")

@Composable
fun UserFavorites() {
    Column() {
        Row() {
            Text(
                text = "Favorite Teams",
                modifier = Modifier
                    .weight(8.5f)
                    .padding(vertical = 25.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 25.sp
            )
        }
        Row() {
            FavoritedTeams(favoriteTeams = favoriteTeams)
        }
        Row() {
            Text(
                text = "Favorite Players",
                modifier = Modifier
                    .weight(8.5f)
                    .padding(vertical = 25.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 25.sp
            )
        }
        Row() {
            FavoritedPlayers(favoritePlayers = favoritePlayers)
        }
    }
}
