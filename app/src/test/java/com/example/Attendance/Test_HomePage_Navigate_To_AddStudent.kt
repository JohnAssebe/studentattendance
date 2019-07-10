package com.example.Attendance

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class Test_HomePage_Navigate_To_AddStudent {

    private lateinit var stringToBeTypedInUsernameEditText: String
    private lateinit var stringToBeTypedInPasswodEditText: String
    private lateinit var stringToBeTypedInCourse:String
    private lateinit var stringToBetyped: String
    @Before
    fun initValidString() {
        stringToBeTypedInUsernameEditText = "Username"
        stringToBeTypedInCourse = "Android"
        stringToBeTypedInPasswodEditText = "Password"
        stringToBetyped = "Registration Successfully"


        fun <T> launchFragmentInContainer(): Any {

        }

        @Test
        fun testLogin_NavigationToInHomeScreen() {
            val mockNavController = Mockito.mock(NavController::class.java)

            val givenScenario = launchFragmentInContainer<LoginFragment>()

            givenScenario.onFragment { fragment ->
                Navigation.setViewNavController(fragment.login_fragment(), mockNavController)
            }
            Espresso.onView(ViewMatchers.withId(R.id.register_button))
                .perform(ViewActions.click())

            Mockito.verify(mockNavController).navigate(R.id.student_fragment)

        }
    }
}
