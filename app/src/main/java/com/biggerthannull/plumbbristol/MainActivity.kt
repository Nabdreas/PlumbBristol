package com.biggerthannull.plumbbristol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.biggerthannull.plumbbristol.ui.navigation.NavigationGraph
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.BottomNavigationComponent
import com.biggerthannull.plumbbristol.ui.views.composables.components.TopBarComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlumbBristolTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopBarComponent()
                    },
                    bottomBar = {
                        BottomNavigationComponent(navController = navController)
                    }
                ) { padding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavigationGraph(navController)
                    }
                }
            }
        }
    }
}