package com.smartplanner.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ModeEdit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smartplanner.Utils.DateUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartDatePicker(
	label: String = "Select date",
	value: Long?,
	onDateSelected: (Long?) -> Unit,
) {
	val showDialog = remember { mutableStateOf(false) }
	val dateState = rememberDatePickerState(initialSelectedDateMillis = value)

	Column(modifier = Modifier.fillMaxWidth()) {
		TextField(
			value = value?.let { DateUtil.millisToFormattedDate(it) } ?: "",
			onValueChange = {},
			readOnly = true,
			label = { Text(label) },
			modifier = Modifier.padding(vertical = 8.dp),
			trailingIcon = {
				Icon(
					Icons.Rounded.ModeEdit,
					contentDescription = "",
					modifier = Modifier.clickable(onClick = { showDialog.value = true })
				)
			})

		if (showDialog.value) {
			DatePickerDialog(onDismissRequest = { showDialog.value = false }, confirmButton = {
				Button(
					onClick = {
					onDateSelected(dateState.selectedDateMillis)
					showDialog.value = false
				},
					shape = RoundedCornerShape(8.dp),
				) {
					Text("OK")
				}
			}, dismissButton = {
				Button(
					onClick = {
					showDialog.value = false
				},
					shape = RoundedCornerShape(8.dp),
					colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
				) {
					Text("Cancel", color = MaterialTheme.colorScheme.onSurfaceVariant)
				}
			}) {
				DatePicker(state = dateState)
			}
		}
	}
}
