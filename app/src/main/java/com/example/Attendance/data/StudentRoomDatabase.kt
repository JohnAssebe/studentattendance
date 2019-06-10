package com.example.Attendance.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class StudentRoomDatabase :RoomDatabase(){
    abstract fun studentDao():StudentDao
    companion object {

        @Volatile
        private var INSTANCE: StudentRoomDatabase? = null

        fun getDatabase(context: Context): StudentRoomDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentRoomDatabase::class.java, "my_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}


