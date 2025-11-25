package com.smartplanner.di

import android.content.Context
import com.smartplanner.data.AppDatabase
import com.smartplanner.data.categories.CategoryDao
import com.smartplanner.data.projects.ProjectDAO
import com.smartplanner.data.tasks.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
	@Provides
	@Singleton
	fun provideDatabase(
		@ApplicationContext context: Context
	): AppDatabase {
		return AppDatabase.Companion.getInstance(context)
	}

	@Provides
	fun provideTaskDao(db: AppDatabase): TaskDao = db.taskDao()

	@Provides
	fun provideProjectDao(db: AppDatabase): ProjectDAO = db.projectDao()

	@Provides
	fun provideCategoryDao(db: AppDatabase): CategoryDao = db.categoryDao()
}