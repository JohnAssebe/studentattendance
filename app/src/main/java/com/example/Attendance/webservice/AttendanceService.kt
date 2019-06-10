package com.example.Attendance.webservice

import com.example.Attendance.data.Attendance
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface AttendanceService {
    @POST("/stddb/attendance")
    fun createAttendanceAsync(@Body newAttendance: Attendance): Deferred<Response<Void>>
    @GET("/stddb/attendance")
    fun getAttendance(): Deferred<Response<List<Attendance>>>

}