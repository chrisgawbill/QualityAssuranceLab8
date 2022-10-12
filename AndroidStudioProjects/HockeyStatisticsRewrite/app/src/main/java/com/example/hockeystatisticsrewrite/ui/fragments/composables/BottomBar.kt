package com.example.hockeystatisticsrewrite.ui.fragments.composables

import androidx.compose.foundation.border
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hockeystatisticsrewrite.ui.theme.Constants

@Composable
fun BottomBar(navHostController: NavHostController) {
    BottomNavigation(backgroundColor = Color.White, modifier = Modifier.border(1.dp, Color.Black)) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navHostController?.currentDestination?.route

        Constants.BottomNavItems.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute === navItem.route,
                onClick = { navHostController.navigate(navItem.route) },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },
                label = {Text(text = navItem.label)},
                alwaysShowLabel = false
            )
        }
    }
}