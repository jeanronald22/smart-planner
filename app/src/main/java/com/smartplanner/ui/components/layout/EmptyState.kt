package com.smartplanner.ui.components.layout


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EmptyState(
	image: Painter,
	title: String,
	subtitle: String,
	buttonText: String,
	onButtonClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(horizontal = 24.dp),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Image(
			painter = image,
			contentDescription = null,
			modifier = Modifier.size(100.dp)
		)

		Spacer(modifier = Modifier.height(16.dp))

		Text(
			text = title,
			style = MaterialTheme.typography.headlineMedium,
			textAlign = TextAlign.Center
		)

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = subtitle,
			style = MaterialTheme.typography.bodyMedium,
			textAlign = TextAlign.Center
		)

		Spacer(modifier = Modifier.height(24.dp))

		Button(
			onClick = onButtonClick,
			shape = RoundedCornerShape(8.dp),
			colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
		) {
			Text(text = buttonText, style = MaterialTheme.typography.labelLarge)
		}
	}
}
