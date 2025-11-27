package com.smartplanner.ui.components.task

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.toString
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smartplanner.ui.components.SmartDatePicker
import com.smartplanner.ui.screens.tasks.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskForm(
	taskViewModel: TaskViewModel,
	onDismiss: () -> Unit,
) {
	val taskState = taskViewModel.task.collectAsState().value
	val task = taskState.data

	Column(
		modifier = Modifier
			.padding(24.dp)
			.fillMaxWidth(),
		verticalArrangement = Arrangement.spacedBy(24.dp),
		horizontalAlignment = Alignment.Start
	) {
		Column {
			Text(
				text = "New Task",
				style = MaterialTheme.typography.headlineMedium
			)

			Text(
				text = "Fill the information below to create your task.",
				style = MaterialTheme.typography.bodyMedium,
				color = MaterialTheme.colorScheme.onSurfaceVariant
			)
		}
		TextField(
			modifier = Modifier.fillMaxWidth(),
			value = task?.title ?: "",
			onValueChange = taskViewModel::updateTitle,
			label = { Text("Title") }
		)

		TextField(
			modifier = Modifier.fillMaxWidth(),
			value = task?.description ?: "",
			onValueChange = taskViewModel::updateDescription,
			label = { Text("Description") },
			maxLines = 10,
			minLines = 4
		)
		Column {
			Text("Completed")
			Switch(
				checked = task?.isCompleted == true,
				onCheckedChange = taskViewModel::updateIsCompleted
			)
		}
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(12.dp)
		) {
			Button(
				onClick = onDismiss,
				modifier = Modifier.weight(1f),
				shape = RoundedCornerShape(8.dp),
				colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)

				) {
				Text("Cancel", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
			}

			Button(
				onClick = {
					taskViewModel.saveTask()
					onDismiss
					taskViewModel.resetTask()
				},
				modifier = Modifier.weight(1f),
				shape = RoundedCornerShape(8.dp),
			) {
				Text("Create", style = MaterialTheme.typography.labelLarge)
			}
		}
	}
}

