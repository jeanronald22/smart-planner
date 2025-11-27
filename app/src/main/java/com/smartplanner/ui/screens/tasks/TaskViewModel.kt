package com.smartplanner.ui.screens.tasks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartplanner.data.tasks.Task
import com.smartplanner.data.tasks.TaskRepository
import com.smartplanner.domain.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
	private val repository: TaskRepository
) : ViewModel() {

	private val _tasks = MutableStateFlow<List<Task>>(emptyList())
	val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

	private val _isLoading = MutableStateFlow(false)
	val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

	private val _task = MutableStateFlow<UIState<Task>>(UIState())
	val task: StateFlow<UIState<Task>> = _task.asStateFlow()


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

	fun updateTitle(newTitle: String) {
		_task.update { it.copy(data = it.data?.copy(title = newTitle)) }
	}

	fun updateDescription(newDescription: String) {
		_task.update { it.copy(data = it.data?.copy(description = newDescription)) }
	}

	fun updateIsCompleted(isCompleted: Boolean) {
		_task.update { it.copy(data = it.data?.copy(isCompleted = isCompleted)) }
	}

	fun updateDeadline(deadline: Long?) {
		_task.update { it.copy(data = it.data?.copy(deadline = deadline)) }
	}

	fun resetTask() {
		_task.update { UIState() }
	}

	fun setTask(task: Task) {
		_task.update { UIState(task) }
	}

	fun saveTask(onSuccess: () -> Unit = {}) {
		viewModelScope.launch {
			val current = _task.value.data ?: return@launch
			repository.insertTask(current)

			resetTask()
			onSuccess()
		}
	}
}
