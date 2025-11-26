package com.smartplanner.ui.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainLayout(
	title: String,
	modifier: Modifier = Modifier,
	actions: @Composable (() -> Unit)? = null,
	content: @Composable () -> Unit
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(horizontal = 16.dp, vertical = 32.dp)
	) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
				text = title,
				style = MaterialTheme.typography.headlineLarge
			)
			actions?.let { it() }
		}
		Spacer(modifier = Modifier.height(16.dp))
		content()
	}
}
