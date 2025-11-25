package com.smartplanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.smartplanner.data.categories.Category
import com.smartplanner.data.categories.CategoryDao
import com.smartplanner.data.projects.Project
import com.smartplanner.data.projects.ProjectDAO
import com.smartplanner.data.tasks.Task
import com.smartplanner.data.tasks.TaskDao

/**
 * Represents the Room database for the Smart Planner application.
 * This database includes tables for tasks, projects, and categories.
 *
 * @Database annotation specifies the entities included in the database,
 * the version of the database schema, and whether to export the schema.
 *
 * @property taskDao Provides access to `Task` data operations.
 * @property projectDao Provides access to `Project` data operations.
 * @property categoryDao Provides access to `Category` data operations.
 */
@Database(
	entities = [Task::class, Project::class, Category::class],
	version = 1,
	exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
	abstract fun taskDao(): TaskDao

	abstract fun projectDao(): ProjectDAO

	abstract fun categoryDao(): CategoryDao

	companion object {
		@Volatile
		private var INSTANCE: AppDatabase? = null

		/**
		 * Retrieves the singleton instance of the `AppDatabase`.
		 * If the instance does not exist, it is created using the Room database builder.
		 *
		 * @param context The application context used to create the database.
		 * @return The singleton instance of `AppDatabase`.
		 */
		fun getInstance(context: Context): AppDatabase {
			return INSTANCE ?: synchronized(this) {
				val instance = Room.databaseBuilder(
					context.applicationContext,
					AppDatabase::class.java,
					"smart_planner_db"
				)
					.fallbackToDestructiveMigration(dropAllTables = true)
					.build()
				INSTANCE = instance
				instance
			}
		}
	}
}