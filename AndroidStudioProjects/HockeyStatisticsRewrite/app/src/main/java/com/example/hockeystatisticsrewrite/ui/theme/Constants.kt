package com.example.hockeystatisticsrewrite.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.hockeystatisticsrewrite.R
import com.example.hockeystatisticsrewrite.models.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = Icons.Default.Home,
            route = "home"
        ),
        BottomNavItem(
            label = "Hub",
            icon = Icons.Default.List,
            route = "hub"
        ),
        BottomNavItem(
            label = "Settings",
            icon = Icons.Default.Settings,
            route = "settings"
        ),
        BottomNavItem(
            label = "Account",
            icon = Icons.Default.Person,
            route = "account"
        )
    )
}