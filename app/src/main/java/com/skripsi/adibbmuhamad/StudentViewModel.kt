package com.skripsi.adibbmuhamad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class StudentViewModel : ViewModel() {
    private val _students = mutableStateOf<List<Student>>(emptyList())
    val students: State<List<Student>> = _students

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun fetchStudents(page: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getStudents(page)
                _students.value = response.data
            } catch (e: Exception) {
                // Handle error, such as showing a Toast or Snackbar
            } finally {
                _isLoading.value = false
            }
        }
    }
}
