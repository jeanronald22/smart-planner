package com.smartplanner.ui.screens.tasks

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.smartplanner.ui.components.layout.MainLayout
import com.smartplanner.R
import com.smartplanner.ui.components.Loader
import com.smartplanner.ui.components.SmartTaskBottomSheet
import com.smartplanner.ui.components.layout.EmptyState
import com.smartplanner.ui.components.task.TaskForm

@Composable
fun TaskScreen(viewModel: TaskViewModel = hiltViewModel()) {
	val task = viewModel.tasks.collectAsState()
	val isLoading = viewModel.isLoading.collectAsState().value
	var showButtomSheet by remember { mutableStateOf(false) }

	MainLayout(title = stringResource(R.string.task)) {
		when {
			isLoading -> {
				Loader()
			}

			task.value.isEmpty() -> {
				EmptyState(
					image = painterResource(id = R.drawable.empty_box),
					title = stringResource(R.string.empty_task),
					subtitle = stringResource(R.string.empty_task_description),
					buttonText = stringResource(R.string.add_task),
					onButtonClick = {showButtomSheet = true}
				)
			}
			else -> {}
		}
		SmartTaskBottomSheet(
			isVisible = showButtomSheet,
			onDismiss = { showButtomSheet = false },
			viewModel = viewModel
		) {
			TaskForm(viewModel, onDismiss = { showButtomSheet = false })
		}
	}
}