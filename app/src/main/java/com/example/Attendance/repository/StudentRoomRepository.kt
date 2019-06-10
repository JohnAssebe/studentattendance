package com.example.Attendance.repository

import androidx.lifecycle.LiveData
import com.example.Attendance.data.Student
import com.example.Attendance.data.StudentDao

class StudentRoomRepository(private val studentDao:StudentDao) {

    fun getAllStudents(): LiveData<Student> {
        return studentDao.getAllStudents()
    }

    fun addStudent(student:Student) {
        studentDao.insertStudent(student)
    }

    fun updateStudent(student:Student) {
        studentDao.updateStudent(student)
    }

    fun deleteCar(student:Student) {
        studentDao.deleteStudent(student)
    }
}