package com.smartplanner.data.tasks

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
	private val taskDao: TaskDao
) : TaskRepository {

	override fun getTasks(): Flow<List<Task>> =
		taskDao.getTasks()

	override fun getTasksByProject(projectId: Int): Flow<List<Task>> =
		taskDao.getTasksByProject(projectId)

	override fun getTasksByCategory(categoryId: Int): Flow<List<Task>> =
		taskDao.getTasksByCategory(categoryId)

	override suspend fun insertTask(task: Task) = taskDao.insertTask(task)

	override suspend fun updateTask(task: Task) = taskDao.updateTask(task)

	override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
}
