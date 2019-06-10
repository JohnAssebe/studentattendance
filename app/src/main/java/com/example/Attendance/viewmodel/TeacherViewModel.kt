package com.example.Attendance.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.Attendance.data.Teacher
import com.example.Attendance.repository.TeacherRepository
import com.example.Attendance.webservice.ServiceBuilder
import com.example.Attendance.webservice.TeacherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
class TeacherViewModel(application: Application):AndroidViewModel(application) {
    private val teacherRepository: TeacherRepository
    init{
        val teacherService= ServiceBuilder.buildService(TeacherService::class.java)
        teacherRepository= TeacherRepository(teacherService)
    }
    fun AddTeacher(teacher: Teacher) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = teacherRepository.addTeacherAsync(teacher).await()
            Log.d("teacher_added", response.message())

        }

    }
    fun AllTeachers(): LiveData<List<Teacher>> {
        val allTeachers: MutableLiveData<List<Teacher>> = MutableLiveData()
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<List<Teacher>> = teacherRepository.getAllTeachers().await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    allTeachers.value = responseBody
                }
            }

        }



        return allTeachers
    }
}