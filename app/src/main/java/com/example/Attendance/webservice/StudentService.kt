package com.example.Attendance.webservice
import com.example.Attendance.data.Student
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*
interface StudentService {

    //to insert students in a database
    @POST("stddb/student")
    fun createStudentsAsync(@Body newStudent: Student): Deferred<Response<Void>>
    @GET("/stddb/student")
    fun getStudents(): Deferred<Response<List<Student>>>
    @GET("/stddb/student/id/{id}")
    fun getStudentByCourseId(@Path("id")id:Int):Deferred<Response<Student>>
    @PUT("/stddb/student/{id}")
    fun updateStudent(
        @Path("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("course") course: String,
        @Field("section") section: String,
        @Field("department") department: String,
        @Field("password") password: String
    ): Deferred<Response<Void>>
    @DELETE("/stddb/student/{id}")
    fun deleteStudentById(@Path("id") id: Int): Deferred<Response<Void>>
}
