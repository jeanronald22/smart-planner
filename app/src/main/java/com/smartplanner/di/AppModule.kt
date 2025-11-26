package com.smartplanner.di

import com.smartplanner.data.tasks.TaskRepository
import com.smartplanner.data.tasks.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

	@Binds
	@Singleton
	abstract fun bindTaskRepository(
		taskRepositoryImpl: TaskRepositoryImpl
	): TaskRepository
}