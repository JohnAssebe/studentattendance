package com.example.Attendance.webservice

import com.example.Attendance.data.Student
import com.example.Attendance.data.StudentEmbedded
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface StudentService {

    //to insert students in a database
    @POST("stddb/student")
    fun createStudentsAsync(@Body newStudent: Student): Deferred<Response<Void>>
    @GET("/stddb/student")
    fun getStudents(): Deferred<Response<List<Student>>>
}
