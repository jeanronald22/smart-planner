package com.smartplanner.data.projects

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a `Project` entity in the database.
 * This data class is annotated with `@Entity` to define a table named `projects`.
 *
 * @property id The unique identifier for the project. It is the primary key and is auto-generated.
 * @property name The name of the project.
 */
@Entity(tableName = "projects")
data class Project(
	@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String
)