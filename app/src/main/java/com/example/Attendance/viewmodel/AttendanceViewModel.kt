package com.example.Attendance.viewmodel
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.Attendance.data.Attendance
import com.example.Attendance.repository.AttendanceRepository
import com.example.Attendance.webservice.AttendanceService
import com.example.Attendance.webservice.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
class AttendanceViewModel (application: Application): AndroidViewModel(application) {
    private val attendanceRepository: AttendanceRepository

    init {
        val attendanceService = ServiceBuilder.buildService(AttendanceService::class.java)
        attendanceRepository = AttendanceRepository(attendanceService)
    }

    fun AddAttendance(attendance: Attendance) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = attendanceRepository.addAttendance(attendance).await()
            Log.d("Attendance_taken", response.message())

        }
    }

    fun getAttendStudents(): LiveData<List<Attendance>> {
        val allAttendStudents: MutableLiveData<List<Attendance>> = MutableLiveData()
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<List<Attendance>> = attendanceRepository.getAttendance().await()
            val responseBody = response.body()
            if (responseBody != null) {
                withContext(Dispatchers.Main) {
                    allAttendStudents.value = responseBody
                }
            }

        }
        return allAttendStudents
    }
}
