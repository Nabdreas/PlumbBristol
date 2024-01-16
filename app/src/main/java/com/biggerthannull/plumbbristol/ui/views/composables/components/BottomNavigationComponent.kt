package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.biggerthannull.plumbbristol.ui.navigation.BottomNavItems

@Composable
fun BottomNavigationComponent(navController: NavController) {

    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Services,
        BottomNavItems.ContactUs
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
                        text = bottomBarItem.title,
                        color = Color.White
                    )
                },
                selected = currentRoute == bottomBarItem.path,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(bottomBarItem.path) {
                        navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                            popUpTo(startDestinationRoute)
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { /*TODO*/ }
            )
        }
    }
}