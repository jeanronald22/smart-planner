package com.smartplanner.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector


enum class SmartPlannerScreen(val route: String, val title: String, val icon: ImageVector) {
	HOME("home", "Home", icon = Icons.Default.Home),
	PROJECTS("projects", "Projects", icon = Icons.Default.Home),
	TASKS("tasks", "Tasks", icon = Icons.Default.Home),
	SETTINGS("settings", "Settings", icon = Icons.Default.Home)
}
