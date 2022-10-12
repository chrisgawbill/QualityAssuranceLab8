package com.example.hockeystatisticsrewrite.ui.fragments.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.hockeystatisticsrewrite.R
import com.example.hockeystatisticsrewrite.ui.theme.HockeyStatisticsRewriteTheme

@Composable
fun FavoritedTeams(modifier: Modifier = Modifier, favoriteTeams: List<String>) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .border(5.dp, Color.Black, RoundedCornerShape(20.dp))
    ) {
        items(favoriteTeams.count()) { index ->
            favoriteTeams[index].let { team ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    ConstraintLayout() {
                        val (teamName, deleteIcon) = createRefs()
                        Text(text = team, modifier = Modifier
                            .width(320.dp)
                            .constrainAs(teamName) {
                                start.linkTo(parent.start, 15.dp)
                                top.linkTo(parent.top, 8.dp)
                            })
                        IconButton(onClick = { deleteFavoriteTeamOnClick(context) },
                            modifier = Modifier.constrainAs(deleteIcon) {
                                start.linkTo(teamName.end)
                                end.linkTo(parent.end, 10.dp)
                                top.linkTo(parent.top)
                            }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete_favorite_icon),
                                contentDescription = "Delete a favorite player or team",
                            )
                        }
                    }
                }
            }
        }
    }
}

fun deleteFavoriteTeamOnClick(context: Context) {
    Toast.makeText(context, "Favorite Team Deleted", Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultFavoriteTeamPreview() {
    HockeyStatisticsRewriteTheme {
        FavoritedTeams(favoriteTeams = listOf("Philadelphia Flyers", "Pittsburgh Penguins"))
    }
}