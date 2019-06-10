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

class LoginFragmentTestEspesso {
    private lateinit var stringToBeTypedInUsernameEditText: String
    private lateinit var stringToBeTypedInPasswodEditText: String
    private lateinit var stringToBetyped: String


    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        stringToBeTypedInUsernameEditText = "Username"
        stringToBeTypedInPasswodEditText = "Password"
        stringToBetyped = "Login Successfully"
        @Test
        fun testThatErrorMessageIsNotIntiallyDisplayed() {
            onView(withId(R.id.error_message))
                .check(matches(not(isDisplayed())))
        }

        @Test
        fun testPasswordLengthRulesTriggersErrorMessage() {
            onView(withId(R.id.password_edit_text)).perform(typeText("john"))
            onView(withId(R.id.login_button)).perform(click())

            onView(withId(R.id.error_message))
                .check(matches(isDisplayed()))
                .check(matches(withText("Password can not be less than 6")))
        }

        @Test
        fun testValidPasswordDoesNotDisplayErrorMessage() {
        }
        onView(withId(R.id.error_message))
            .perform(typeText("Long valid password"))
        onView(withId(R.id.login_button))
            .perform(click())
        onView(withId(R.id.error_message))
            .check(matches(not(isDisplayed())))
        @Test

        fun loginBtnClicked_homeNavigation() {
            initValidString()
            onView(withId(R.id.user_name_edit_text))
                .perform(typeText(this.stringToBeTypedInUsernameEditText), closeSoftKeyboard())
            onView(withId(R.id.password_edit_text))
                .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
            onView(withId(R.id.login_button)).perform(click())

            onView(withId(R.id.textview_for_login_success))
                .check(matches(withText(stringToBetyped)))
        }

        @Test
        fun testLoginFragmenNotRedirectToHomePage() {
            onView(withId(R.id.user_name_edit_text))
                .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())
                .check(matches(not("Username")))

            onView(withId(R.id.password_edit_text))
                .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
                .check(matches(not("Password")))
            onView(withId(R.id.login_button))
                .perform(click())
            onView(withId(R.id.home_fragment))
                .check(matches(not(isDisplayed())))

        }

        @Test
        fun testLoginFragmenRedirectToHomePage() {
            onView(withId(R.id.user_name_edit_text))
                .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())
                .check(matches(withText("Username")))

            onView(withId(R.id.password_edit_text))
                .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
                .check(matches(withText("Password")))
            onView(withId(R.id.login_button))
                .perform(click())
            onView(withId(R.id.home_fragment))
                .check(matches(isDisplayed()))

        }

        @Test
        fun testLoginSuccessMessageDisplayed() {
            onView(withId(R.id.user_name_edit_text))
                .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())
                .check(matches(withText("Username")))

            onView(withId(R.id.password_edit_text))
                .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
                .check(matches(withText("Password")))
            onView(withId(R.id.login_button))
                .perform(click())
            onView(withText(stringToBetyped))
                .check(matches(isDisplayed()))
        }

        @Test
        fun testLoginSuccessMessageNotDisplayed() {
            initValidString()
            onView(withId(R.id.user_name_edit_text))
                .perform(typeText(stringToBeTypedInUsernameEditText), closeSoftKeyboard())

            onView(withId(R.id.password_edit_text))
                .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
            onView(withId(R.id.login_button))
                .perform(click())
            onView(withText(stringToBetyped))
                .check(matches(not(isDisplayed())))


        }


    }
}