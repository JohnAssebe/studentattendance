package com.example.Attendance.repository

import com.example.Attendance.data.Student
import com.example.Attendance.webservice.StudentService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class StudentRepository(private val studentService: StudentService) {
    fun addStudentAsync(student:Student): Deferred<Response<Void>> {
        return studentService.createStudentsAsync(student)
    }
    fun getAllStudentsAsync(): Deferred<Response<List<Student>>> {
        return studentService.getStudents()
    }
    fun getStudentByCourseId(id:Int): Deferred<Response<Student>> {
        return studentService.getStudentByCourseId(id)
    }
    fun DeleteStudentById(id:Int): Deferred<Response<Void>>{
        return studentService.deleteStudentById(id)
    }
}