package com.smartplanner.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smartplanner.ui.screens.tasks.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SmartTaskBottomSheet(
	isVisible: Boolean = false,
	onDismiss: () -> Unit,
	viewModel: T,
	content: @Composable (T) -> Unit
) {
	if (isVisible) {
		ModalBottomSheet(onDismissRequest = onDismiss) {
			content(viewModel)
		}
	}
}
