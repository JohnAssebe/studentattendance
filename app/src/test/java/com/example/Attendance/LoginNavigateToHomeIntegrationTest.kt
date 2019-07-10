package com.example.Attendance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class LoginNavigateToHomeIntegrationTest {

    private lateinit var stringToBeTypedInUsernameEditText: String
    private lateinit var stringToBeTypedInPasswodEditText: String
    private lateinit var stringToBetyped: String
    @Before
    fun initValidString() {
        stringToBeTypedInUsernameEditText = "Username"
        stringToBeTypedInPasswodEditText = "Password"
        stringToBetyped = "Login Successfully"


        @Test
        fun testLogin_NavigationToInHomeScreen() {
            val mockNavController = mock(NavController::class.java)

            val givenScenario = launchFragmentInContainer<LoginFragment>()

            givenScenario.onFragment { fragment ->
                Navigation.setViewNavController(fragment.requireView(), mockNavController)
            }
            onView(ViewMatchers.withId(R.id.login_button))
                .perform(ViewActions.click())
            initValidString()
            onView(ViewMatchers.withId(R.id.user_name_edit_text))
                .perform(
                    ViewActions.typeText(stringToBeTypedInUsernameEditText),
                    ViewActions.closeSoftKeyboard()
                )
            onView(ViewMatchers.withId(R.id.password_edit_text))
                .perform(
                    ViewActions.typeText(stringToBeTypedInPasswodEditText),
                    ViewActions.closeSoftKeyboard())

            verify(mockNavController).navigate(R.id.home_fragment)

            onView(ViewMatchers.withId(R.id.textview_for_login_success))
                .check(ViewAssertions.matches(ViewMatchers.withText(stringToBetyped)))
        }
    }
}