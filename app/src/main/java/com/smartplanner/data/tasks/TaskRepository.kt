package com.smartplanner.data.tasks

import kotlinx.coroutines.flow.Flow

interface TaskRepository {
	fun getTasks(): Flow<List<Task>>
	fun getTasksByProject(projectId: Int): Flow<List<Task>>
	fun getTasksByCategory(categoryId: Int): Flow<List<Task>>

	suspend fun insertTask(task: Task)
	suspend fun updateTask(task: Task)
	suspend fun deleteTask(task: Task)
}
