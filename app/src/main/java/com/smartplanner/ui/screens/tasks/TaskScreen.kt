package com.smartplanner.ui.screens.tasks

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.smartplanner.ui.components.layout.MainLayout
import com.smartplanner.R
import com.smartplanner.ui.components.Loader
import com.smartplanner.ui.components.layout.EmptyState

@Composable
fun TaskScreen(viewModel: TaskViewModel = hiltViewModel()) {
	val task = viewModel.tasks.collectAsState()
	val isLoading = viewModel.isLoading.collectAsState().value
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
					onButtonClick = {}
				)
			}else -> {}
		}
	}
}