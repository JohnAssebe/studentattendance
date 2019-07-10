package com.example.Attendance.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.Attendance.data.Student
import com.example.Attendance.data.StudentRoomDatabase
import com.example.Attendance.repository.StudentRoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentRoomViewModel(application: Application): AndroidViewModel(application) {
    private val StudentRepository:StudentRoomRepository
    init {
        val studentDAO = StudentRoomDatabase.getDatabase(application).studentDao()
        StudentRepository = StudentRoomRepository(studentDAO)

    }
    fun getAllStudents(): LiveData<List<Student>> {
        lateinit var student: LiveData<List<Student>>
        viewModelScope.launch(Dispatchers.IO){
            student= StudentRepository.getAllStudents()
        }

        return student
    }


}