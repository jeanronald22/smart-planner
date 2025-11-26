package com.smartplanner.ui.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.AddTask
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smartplanner.domain.BottomBarItem

@Composable
fun SmartBottomBar(
	items: List<BottomBarItem>,
	currentRoute: String,
	onItemSelected: (BottomBarItem) -> Unit,
	onFabClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = 20.dp, vertical = 40.dp)
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {

			Row(
				modifier = Modifier
					.shadow(
						elevation = 2.dp,
						shape = RoundedCornerShape(38.dp),
						spotColor = Color.Black.copy(alpha = 0.5f)
					)
					.clip(RoundedCornerShape(38.dp))
					.background(MaterialTheme.colorScheme.surface)
					.padding(horizontal = 12.dp, vertical = 12.dp),
				horizontalArrangement = Arrangement.spacedBy(8.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				items.forEach { item ->
					SmartBottomBarItem(
						item = item,
						isSelected = item.route == currentRoute,
						onClick = { onItemSelected(item) }
					)
				}
			}

		}
	}
}

