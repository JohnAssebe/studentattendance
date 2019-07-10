package com.example.Attendance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest

@RunWith(AndroidJUnit4::class)
class RegistraionFragmentE2ETest {
    private lateinit var stringToBeTypedInUsernameEditText: String
    private lateinit var stringToBeTypedInPasswodEditText: String
    private lateinit var stringToBeTypedInCourse: String
    private lateinit var stringToBeTyped: String


    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        stringToBeTypedInUsernameEditText = "Username"
        stringToBeTypedInPasswodEditText = "Password"
        stringToBeTypedInCourse = "Course"
        stringToBeTyped = "Registered Successfully"
}
    @Test
    fun testLoginFragmentRedirectToLoginFragment(){
        initValidString()
        onView(withId(R.id.user_name_edit_text))
            .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
        onView(withId(R.id.course))
            .perform(typeText(stringToBeTypedInCourse), closeSoftKeyboard())
        onView(withId(R.id.register_button))
            .perform(click())
        onView(withId(R.id.login_fragment))
            .check(matches(isDisplayed()))

    }
    @Test
    fun testRegistrationSuccessMessageDisplayed(){
       initValidString()
        onView(withId(R.id.user_name_edit_text))
            .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())

        onView(withId(R.id.course))
            .perform(typeText(stringToBeTypedInCourse), closeSoftKeyboard())


        onView(withId(R.id.register_button))
            .perform(click())
        onView(withId(R.id.textview_for_registration_success))
            .check(matches(isDisplayed()))
        onView(withId(R.id.login_fragment))
            .check(matches(isDisplayed()))

    }
    @Test
    fun testRegistrationSuccessMessageNotDisplayed(){
        initValidString()
        onView(withId(R.id.user_name_edit_text))
            .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())

        onView(withId(R.id.course))
            .perform(typeText(stringToBeTypedInCourse), closeSoftKeyboard())

        onView(withId(R.id.register_button))
            .perform(click())
        onView(withId(R.id.login_fragment))
            .check(matches(not(isDisplayed())))
        onView(withId(R.id.textview_for_registration_success))
               .check(matches(not(isDisplayed())))

    }
}