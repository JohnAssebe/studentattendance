package com.example.Attendance.repository
import com.example.Attendance.data.Teacher
import com.example.Attendance.webservice.TeacherService
import kotlinx.coroutines.Deferred
import retrofit2.Response
class TeacherRepository (private val teacherService: TeacherService){
    fun addTeacherAsync(teacher:Teacher): Deferred<Response<Void>> {
        return teacherService.createTeachersAsync(teacher)
    }
    fun getAllTeachers(): Deferred<Response<List<Teacher>>>{
        return teacherService.getTeacher()

    }
}