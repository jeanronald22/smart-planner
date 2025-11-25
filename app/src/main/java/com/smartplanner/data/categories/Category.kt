package com.smartplanner.data.categories

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a category stored in the `categories` table.
 *
 * A Category groups related items and carries a display color.
 *
 * @property id Unique identifier for the category. This is the primary key and is auto-generated.
 * @property name Human-readable name of the category.
 * @property color Color associated with the category, stored as a Long (e.g., ARGB).
 */
@Entity(tableName = "categories")
data class Category(
	@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String, val color: Long
)
