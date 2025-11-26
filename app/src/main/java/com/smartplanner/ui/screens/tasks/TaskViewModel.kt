package com.smartplanner.ui.screens.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartplanner.data.tasks.Task
import com.smartplanner.data.tasks.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
	private val repository: TaskRepository
): ViewModel() {
	private val _tasks = MutableStateFlow<List<Task>>(emptyList())
	val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

	private val _isLoading = MutableStateFlow(false)
	val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

	init {
		loadTasks()
	}

	private fun loadTasks() {
		viewModelScope.launch {
			_isLoading.value = true
			repository.getTasks().collect { taskList ->
				_tasks.value = taskList
				_isLoading.value = false
			}
		}
	}
}