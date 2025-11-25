package com.smartplanner.data.categories

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for managing `Category` entities in the database.
 * This interface defines methods for interacting with the `categories` table.
 * It uses Room annotations to map SQL queries to Kotlin functions.
 */
@Dao
interface CategoryDao {
	@Query("SELECT * FROM categories")
	fun getCategories(): Flow<List<Category>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertCategory(category: Category)

	@Delete
	suspend fun deleteCategory(category: Category)
}