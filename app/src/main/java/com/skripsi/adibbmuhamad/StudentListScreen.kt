package com.skripsi.adibbmuhamad

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun StudentListScreen(viewModel: StudentViewModel) {
    val students by viewModel.students
    val isLoading by viewModel.isLoading

    LaunchedEffect(Unit) {
        viewModel.fetchStudents(page = 1)
    }

    if (isLoading) {
        LoadingScreen()
    } else {
        StudentList(students)
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun StudentList(students: List<Student>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(students) { student ->
            StudentItem(student)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StudentItem(student: Student) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = student.name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Class: ${student.class_room}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Parent Email: ${student.parent_email}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Address: ${student.address}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListScreen() {
    val students = listOf(
        Student(1, "Cayadi Siregar M.Ak", "7A", "hadi.uyainah@yahoo.co.id", "1818624585", "Kpg. Arifin No. 602, Pekalongan", "2025-03-02T23:26:12.000000Z", "2025-03-02T23:26:12.000000Z")
    )
    StudentList(students)
}

@Preview
@Composable
private fun StudentListScreenPreview() {
    val viewModel = StudentViewModel()
    StudentListScreen(viewModel)
}
