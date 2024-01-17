package com.biggerthannull.plumbbristol.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.biggerthannull.plumbbristol.ui.navigation.models.BottomNavPaths

sealed class BottomNavItems(var title: String, var path: String, val icon: ImageVector)  {
    data object Home: BottomNavItems("Home", BottomNavPaths.HOME, Icons.Filled.Home)
    data object Services: BottomNavItems("Services", BottomNavPaths.SERVICES, Icons.Filled.Build)
    data object Team: BottomNavItems("Team", BottomNavPaths.TEAM, Icons.Filled.Face)
    data object ContactUs: BottomNavItems("Contact", BottomNavPaths.CONTACT_US, Icons.Filled.Info)

}