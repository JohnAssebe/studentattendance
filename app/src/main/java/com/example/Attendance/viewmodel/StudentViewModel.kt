package com.example.Attendance.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.Attendance.data.Student
import com.example.Attendance.repository.StudentRepository
import com.example.Attendance.webservice.ServiceBuilder
import com.example.Attendance.webservice.StudentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
class StudentViewModel(application: Application): AndroidViewModel(application) {
    private val studentRepository:StudentRepository
    init{
        val studentService= ServiceBuilder.buildService(StudentService::class.java)
        studentRepository= StudentRepository(studentService)
    }
    fun getAllStudents(): LiveData<List<Student>> {
        val allStudents: MutableLiveData<List<Student>> = MutableLiveData()
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<List<Student>> = studentRepository.getAllStudentsAsync().await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    allStudents.value = responseBody
                }
            }

        }



        return allStudents
    }

        fun AddStudent(student:Student) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = studentRepository.addStudentAsync(student).await()
            Log.d("student_added", response.message())

        }
    }
}