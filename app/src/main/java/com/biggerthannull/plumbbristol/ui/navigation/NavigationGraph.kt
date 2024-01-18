package com.biggerthannull.plumbbristol.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.biggerthannull.plumbbristol.ui.navigation.models.NavArguments.BATHROOM_ID
import com.biggerthannull.plumbbristol.ui.navigation.models.NavPaths
import com.biggerthannull.plumbbristol.ui.views.composables.screens.BathroomDetailsScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.ProfileScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.HomeScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.ServicesScreen
import com.biggerthannull.plumbbristol.ui.views.composables.screens.TeamScreen
import com.biggerthannull.plumbbristol.ui.views.viewmodels.BathroomDetailsViewModel
import com.biggerthannull.plumbbristol.ui.views.viewmodels.HomeViewModel
import com.biggerthannull.plumbbristol.ui.views.viewmodels.ProfileViewModel
import com.biggerthannull.plumbbristol.ui.views.viewmodels.TeamViewModel
import com.biggerthannull.plumbbristol.ui.views.viewmodels.events.DetailsUserEvents

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItems.Home.path) {
        composable(BottomNavItems.Home.path) {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            HomeScreen(uiState, navController)
        }
        composable(BottomNavItems.Services.path) {
            ServicesScreen()
        }
        composable(BottomNavItems.Profile.path) {
            val viewModel: ProfileViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            ProfileScreen(uiState)
        }
        composable(BottomNavItems.Team.path) {
            val viewModel: TeamViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            TeamScreen(uiState)
        }
        composable(
            NavPaths.BATHROOM_DETAILS_PATH,
            arguments = listOf(navArgument(BATHROOM_ID) { type = NavType.StringType })
        ) {
            val viewModel: BathroomDetailsViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            val events = viewModel as DetailsUserEvents
            BathroomDetailsScreen(uiState, events)
        }
    }
}