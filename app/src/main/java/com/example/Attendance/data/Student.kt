package com.example.Attendance.data

import androidx.room.Entity

@Entity(tableName="student")
data class Student (
     val id:Int,
     val first_name:String,
     val last_name:String,
     val course:String,
     val section:String,
     val department:String,
     val password:String
)