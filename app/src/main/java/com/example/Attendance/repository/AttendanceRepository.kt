package com.example.Attendance.repository

import com.example.Attendance.data.Attendance
import com.example.Attendance.webservice.AttendanceService
import kotlinx.coroutines.Deferred
import retrofit2.Response
class AttendanceRepository(private val attendanceService:AttendanceService) {
    fun addAttendance(attendance:Attendance): Deferred<Response<Void>> {
        return attendanceService.createAttendanceAsync(attendance)
    }
    fun getAttendance():Deferred<Response<List<Attendance>>> {
        return attendanceService.getAttendance()
    }
}