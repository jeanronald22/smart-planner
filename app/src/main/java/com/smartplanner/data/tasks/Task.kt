package com.smartplanner.data.tasks

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.smartplanner.data.categories.Category
import com.smartplanner.data.projects.Project

/**
 * Represents a `Task` entity stored in the `tasks` table.
 *
 * A `Task` is associated with a `Project` and a `Category`, and includes details such as
 * its title, description, completion status, and optional deadline.
 *
 * @property id Unique identifier for the task. This is the primary key and is auto-generated.
 * @property title Title of the task.
 * @property description Detailed description of the task.
 * @property isCompleted Indicates whether the task is completed.
 * @property deadline Optional deadline for the task, represented as a timestamp (in milliseconds).
 * @property projectId  ID of the associated project. If the project is deleted, this value is also deleted.
 * @property categoryId ID of the associated category. If the category is deleted, the task is also deleted.
 */
@Entity(
	tableName = "tasks", foreignKeys = [ForeignKey(
		entity = Project::class,
		parentColumns = ["id"],
		childColumns = ["projectId"],
		onDelete = ForeignKey.CASCADE
	), ForeignKey(
		entity = Category::class,
		parentColumns = ["id"],
		childColumns = ["categoryId"],
		onDelete = ForeignKey.CASCADE
	)], indices = [Index("projectId"), Index("categoryId")]
)
data class Task(
	@PrimaryKey(autoGenerate = true) val id: Int = 0,
	val title: String,
	val description: String,
	val isCompleted: Boolean,
	val deadline: Long? = null,
	val projectId: Int? = null,
	val categoryId: Int
)
