package com.example.Attendance.webservice
import com.example.Attendance.data.Teacher
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*
interface TeacherService {
    @POST("/stddb/teacher")
    fun createTeachersAsync(@Body newTeacher: Teacher): Deferred<Response<Void>>
    @POST("/stddb/teacher/login")
    fun CheckLogin(@Body loginTrial:Teacher): Deferred<Response<Void>>
}