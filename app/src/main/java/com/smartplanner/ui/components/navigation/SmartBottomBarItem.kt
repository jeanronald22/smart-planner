package com.smartplanner.ui.components.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.smartplanner.domain.BottomBarItem

@Composable
fun SmartBottomBarItem(
	item: BottomBarItem,
	isSelected: Boolean,
	onClick: () -> Unit
) {
	val scale by animateFloatAsState(
		targetValue = if (isSelected) 1.6f else 1f,
		animationSpec = tween(durationMillis = 100),
		label = "scale"
	)

	val iconTint by animateColorAsState(
		targetValue = if (isSelected) MaterialTheme.colorScheme.primary
		else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
		animationSpec = tween(durationMillis = 200),
		label = "tint"
	)

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.clip(CircleShape)
			.clickable(
				interactionSource = remember { MutableInteractionSource() },
				indication = null,
				onClick = onClick
			)
			.padding(horizontal = 8.dp, vertical = 8.dp)
	) {
		Icon(
			imageVector = item.icon,
			contentDescription = item.title,
			tint = iconTint,
			modifier = Modifier
				.size(24.dp)
				.scale(scale)
		)
	}
}