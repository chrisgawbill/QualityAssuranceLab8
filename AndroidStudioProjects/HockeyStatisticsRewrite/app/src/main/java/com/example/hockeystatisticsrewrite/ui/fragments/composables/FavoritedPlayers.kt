package com.example.hockeystatisticsrewrite.ui.fragments.composables

import android.content.Context
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.hockeystatisticsrewrite.R
import com.example.hockeystatisticsrewrite.ui.theme.HockeyStatisticsRewriteTheme

@Composable
fun FavoritedPlayers(modifier: Modifier = Modifier, favoritePlayers: List<String>) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .border(5.dp, Color.Black, RoundedCornerShape(20.dp))
    ) {
        items(favoritePlayers.count()) { index ->
            favoritePlayers[index].let { player ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    ConstraintLayout() {
                        val (playerName, deleteIcon) = createRefs()
                        ClickableText(text = AnnotatedString(player), modifier = Modifier
                            .width(320.dp)
                            .constrainAs(playerName) {
                                start.linkTo(parent.start, 15.dp)
                                top.linkTo(parent.top, 12.dp)
                            },
                        onClick = { playerTextOnClick(player, context) })
                        IconButton(onClick = { deleteFavoritePlayerOnClick(context) },
                            modifier = Modifier.constrainAs(deleteIcon) {
                                start.linkTo(playerName.end)
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

fun deleteFavoritePlayerOnClick(context: Context) {
    Toast.makeText(context, "Favorite Player Deleted", Toast.LENGTH_SHORT).show()
}
fun playerTextOnClick(playerName:String, context: Context){
    Toast.makeText(context, playerName, Toast.LENGTH_SHORT).show()
}
@Preview(showBackground = true)
@Composable
fun DefaultFavoritePlayerPreview() {
    HockeyStatisticsRewriteTheme {
        FavoritedPlayers(favoritePlayers = listOf("Claude Giroux", "Sidney Crosby"))
    }
}