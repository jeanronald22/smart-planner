package com.smartplanner.data.projects

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for managing `Project` entities in the database.
 * This interface defines methods for interacting with the `projects` table.
 * It uses Room annotations to map SQL queries to Kotlin functions.
 */
@Dao
interface ProjectDAO {

	@Query("SELECT * FROM projects")
	fun getProjects(): Flow<List<Project>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun addProject(project: Project)

	@Delete
	suspend fun deleteProject(project: Project)
}