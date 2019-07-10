package com.example.Attendance

    import androidx.test.espresso.Espresso
    import androidx.test.espresso.Espresso.onView
    import androidx.test.espresso.action.ViewActions
    import androidx.test.espresso.assertion.ViewAssertions
    import androidx.test.espresso.matcher.ViewMatchers
    import androidx.test.runner.AndroidJUnit4
    import kotlinx.android.synthetic.main.login_fragment.view.*
    import org.junit.Before
    import org.junit.Test
    import org.junit.runner.RunWith
    import org.mockito.Mockito
    import org.mockito.Mockito.mock
    import org.mockito.Mockito.verify

    @RunWith(AndroidJUnit4::class)
    class RegistrationNavigateToLogin {

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


            @Test
            fun testLogin_NavigationToInHomeScreen() {
                val mockNavController = Mockito.mock(NavController::class.java)

                val givenScenario = launchFragmentInContainer<LoginFragment>()

                givenScenario.onFragment { fragment ->
                    Navigation.setViewNavController(fragment.login_fragment(), mockNavController)
                }
                Espresso.onView(ViewMatchers.withId(R.id.register_button))
                    .perform(ViewActions.click())
                initValidString()
                Espresso.onView(ViewMatchers.withId(R.id.user_name_edit_text))
                    .perform(
                        ViewActions.typeText(stringToBeTypedInUsernameEditText),
                        ViewActions.closeSoftKeyboard())

                Espresso.onView(ViewMatchers.withId(R.id.password_edit_text))
                    .perform(
                        ViewActions.typeText(stringToBeTypedInPasswodEditText),
                        ViewActions.closeSoftKeyboard())

                Espresso.onView(ViewMatchers.withId(R.id.course))
                    .perform(
                        ViewActions.typeText(stringToBeTypedInCourse),
                        ViewActions.closeSoftKeyboard())

                Mockito.verify(mockNavController).navigate(R.id.login_fragment)
                onView(ViewMatchers.withId(R.id.textview_for_login_success))
                    .check(ViewAssertions.matches(ViewMatchers.withText(stringToBetyped)))
            }
        }
    }
}