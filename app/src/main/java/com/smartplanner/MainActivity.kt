package com.smartplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.smartplanner.domain.BottomBarItem
import com.smartplanner.ui.components.navigation.SmartBottomBar
import com.smartplanner.ui.screens.home.HomeScreen
import com.smartplanner.ui.screens.settings.Settings
import com.smartplanner.ui.screens.tasks.TaskScreen
import com.smartplanner.ui.screens.tasks.TaskViewModel
import com.smartplanner.ui.theme.SmartPlannerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			SmartPlannerTheme {
				val navController = rememberNavController()
				val currentRoute =
					navController.currentBackStackEntryAsState().value?.destination?.route
				Box(
					modifier = Modifier
						.fillMaxSize()
				) {
					NavHost(
						navController = navController,
						startDestination = BottomBarItem.HOME.route,
						modifier = Modifier.fillMaxSize()
					) {
						composable(BottomBarItem.HOME.route) { HomeScreen() }
						composable(BottomBarItem.SETTINGS.route) { Settings() }
						composable(BottomBarItem.TASKS.route) {
							TaskScreen()
						}
					}

					Box(
						modifier = Modifier
							.align(Alignment.BottomCenter)
							.fillMaxWidth()
					) {
						SmartBottomBar(
							items = BottomBarItem.entries,
							currentRoute = currentRoute ?: BottomBarItem.HOME.route,
							onItemSelected = { item ->
								navController.navigate(item.route) {
									launchSingleTop = true
									restoreState = true
								}
							},
							onFabClick = {

							})
					}
				}
			}
		}
	}
}
