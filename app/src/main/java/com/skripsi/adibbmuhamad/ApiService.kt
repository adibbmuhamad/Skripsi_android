package com.skripsi.adibbmuhamad

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/students")
    suspend fun getStudents(
        @Query("page") page: Int
    ): StudentResponse
}
