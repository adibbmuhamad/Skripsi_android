package com.skripsi.adibbmuhamad

data class Student(
    val id: Int,
    val name: String,
    val class_room: String,
    val parent_email: String,
    val nisn: String,
    val address: String,
    val created_at: String,
    val updated_at: String
)

data class StudentResponse(
    val data: List<Student>,
    val links: Links,
    val meta: Meta
)

data class Links(
    val first: String?,
    val last: String?,
    val prev: String?,
    val next: String?
)

data class Meta(
    val current_page: Int,
    val last_page: Int,
    val total: Int
)
