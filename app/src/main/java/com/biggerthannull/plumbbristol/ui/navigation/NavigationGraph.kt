package com.biggerthannull.plumbbristol.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.biggerthannull.plumbbristol.ui.views.composables.screens.ContactUsScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.LandingScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.ServicesScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItems.Home.path) {
        composable(BottomNavItems.Home.path) {
            LandingScreen()
        }
        composable(BottomNavItems.Services.path) {
            ServicesScreen()
        }
        composable(BottomNavItems.ContactUs.path) {
            ContactUsScreen()
        }
    }
}