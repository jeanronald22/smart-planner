package com.smartplanner.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Task
import androidx.compose.ui.graphics.vector.ImageVector


enum class BottomBarItem(val route: String, val title: String, val icon: ImageVector) {
	HOME("home", "Home", icon = Icons.Rounded.Home),
	TASKS("tasks", "Tasks", icon = Icons.Rounded.Task),
	CALENDAR("calendar", "Calendar", icon = Icons.Rounded.CalendarMonth),
	PROJECTS("projects", "Projects", icon = Icons.Rounded.Folder),
	SETTINGS("settings", "Settings", icon = Icons.Rounded.AccountCircle),
}
