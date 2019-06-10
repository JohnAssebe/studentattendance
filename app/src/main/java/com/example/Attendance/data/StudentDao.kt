package com.example.Attendance.data

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface StudentDao {
    @Query("SELECT * FROM student")
    fun getAllStudents(): LiveData<Student>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun insertStudent(student:Student)

    @Update
    fun updateStudent(student:Student)

    @Delete
    fun deleteStudent(student: Student)
}