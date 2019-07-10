package com.example.Attendance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.Attendance.repository.StudentRepository
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.fragment_student_for_teacher.view.*
import org.junit.Test
import org.mockito.Mockito.mock

class StudentInfoSaved_IntegrationTest {
    @Test
    fun Student_Info_Saved(){
val navController = mock(NavController::class.java)
        LaunchFragment(navController)


        onView(withId(R.id.first_name)).perform(replaceText(    "First Name"))
        onView(withId(R.id.last_name)).perform(replaceText("Last Name"))
        onView(withId(R.id.section)).perform(replaceText("03"))
        onView(withId(R.id.department)).perform(replaceText("Department"))
        onView(withId(R.id.course)).perform(replaceText("Course"))
        onView(withId(R.id.password_edit_text)).perform(replaceText("Password"))
        onView(withId(R.id.add_button)).perform(click())


        val students = (StudentRepository.addStudentAsync(true) as Result.Success).data
        assertEquals(students.size,1)
        assertEquals(students[0].first_name,"First Name")
        assertEquals(students[0].last_name,"Last Name")
        assertEquals(students[0].section,"03")
        assertEquals(students[0].department,"Software")
        assertEquals(students[0].course,"Android")
        assertEquals(students[0].password_edit_text,"password")




    }
}