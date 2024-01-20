package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.biggerthannull.plumbbristol.ui.navigation.BottomNavItems
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun BottomNavigationComponent(navController: NavController) {

    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Discover,
        BottomNavItems.Services,
        BottomNavItems.Team,
        BottomNavItems.Profile
    )
    BottomNavigation(
        backgroundColor = PlumbBristolTheme.colour.black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { bottomBarItem ->
            BottomNavigationItem(
                label = {
                    Text(
                        text = bottomBarItem.title,
                        color = PlumbBristolTheme.colour.white,
                        style = PlumbBristolTheme.typography.basicText
                    )
                },
                selectedContentColor = PlumbBristolTheme.colour.white,
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
                        tint = PlumbBristolTheme.colour.white,
                        contentDescription = bottomBarItem.title,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }
    }
}