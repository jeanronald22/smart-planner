package com.smartplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smartplanner.domain.SmartPlannerScreen
import com.smartplanner.ui.screens.home.HomeScreen
import com.smartplanner.ui.theme.SmartPlannerTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			val navController = rememberNavController()
			val startDestination = SmartPlannerScreen.HOME
			var selectedDestionation by rememberSaveable { mutableStateOf(startDestination) }
			SmartPlannerTheme {
				Scaffold(
					bottomBar = { NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
						SmartPlannerScreen.entries.forEachIndexed { index, screen ->
							NavigationBarItem(
								selected = selectedDestionation == screen,
								onClick = {
//									navController.navigate(screen.route)
										  },
								icon = { Icon(screen.icon, contentDescription = screen.title) },
								label = { Text(text = screen.title) }
							)
						}
					}},
					modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					NavHost(
						navController = navController,
						startDestination = SmartPlannerScreen.HOME.name,
						modifier = Modifier.padding(innerPadding)
					) {
						composable(route = SmartPlannerScreen.HOME.name) {
							HomeScreen()
						}
					}
				}
			}
		}
	}
}
