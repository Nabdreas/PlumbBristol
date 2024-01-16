package com.biggerthannull.plumbbristol.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.biggerthannull.plumbbristol.ui.views.composables.screens.ContactUsScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.HomeScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.ServicesScreen
import com.biggerthannull.plumbbristol.ui.views.viewmodels.HomeViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItems.Home.path) {
        composable(BottomNavItems.Home.path) {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            HomeScreen(uiState)
        }
        composable(BottomNavItems.Services.path) {
            ServicesScreen()
        }
        composable(BottomNavItems.ContactUs.path) {
            ContactUsScreen()
        }
    }
}