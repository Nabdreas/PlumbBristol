package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.biggerthannull.plumbbristol.ui.navigation.BottomNavItems

@Composable
fun BottomNavigationComponent(navController: NavController) {

    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Services,
        BottomNavItems.Team,
        BottomNavItems.Profile
    )
    BottomNavigation(
        backgroundColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { bottomBarItem ->
            BottomNavigationItem(
                label = {
                    Text(
                        text = bottomBarItem.title, color = Color.White, style = TextStyle(
                            fontWeight = FontWeight.Bold, fontSize = 12.sp
                        )
                    )
                },
                selectedContentColor = Color.White,
                selected = currentRoute == bottomBarItem.path,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(bottomBarItem.path) {
                        navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                            popUpTo(startDestinationRoute)
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = bottomBarItem.icon,
                        tint = Color.White,
                        contentDescription = bottomBarItem.title,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }
    }
}