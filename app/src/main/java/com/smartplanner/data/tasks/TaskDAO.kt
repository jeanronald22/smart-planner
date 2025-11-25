package com.smartplanner.data.tasks

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for managing `Task` entities in the database.
 * This interface defines methods for interacting with the `tasks` table.
 * It uses Room annotations to map SQL queries to Kotlin functions.
 */
@Dao
interface TaskDao {
	@Query("SELECT * FROM tasks")
	fun getTasks(): Flow<List<Task>>

	@Query("SELECT * FROM tasks WHERE projectId = :projectId")
	fun getTasksByProject(projectId: Int): Flow<List<Task>>

	@Query("SELECT * FROM tasks WHERE categoryId = :categoryId")
	fun getTasksByCategory(categoryId: Int): Flow<List<Task>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertTask(task: Task)

	@Update
	suspend fun updateTask(task: Task)

	@Delete
	suspend fun deleteTask(task: Task)
}
