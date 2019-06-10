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
class StudentFragmentE2ETest {
    private lateinit var stringToBeTypedInFirstNameEditText: String
    private lateinit var stringToBeTypedInLastNameEditText: String
    private var stringToBeTypedInSectionEditText: Int = 0
    private lateinit var stringToBeTypedInCourseEditText: String
    private lateinit var stringToBeTypedInDepartmentEditText: String
    private lateinit var stringToBeTypedInPasswodEditText: String
    private lateinit var stringToBeTyped: String
    private lateinit var  successForSection: String
    private lateinit var notSuccessForPassword:String
    private lateinit var notSuccessForSection:String
    private lateinit var successForPassword:String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        notSuccessForSection = "Section can not be string"
        successForPassword = "Right Password format"
        stringToBeTypedInFirstNameEditText = "FirstName"
        stringToBeTypedInLastNameEditText = "LastName"
        stringToBeTypedInSectionEditText = 3
        stringToBeTypedInCourseEditText = "Course"
        stringToBeTypedInDepartmentEditText = "Department"
        stringToBeTypedInPasswodEditText = "Password"
        stringToBeTyped = "Student Added Successfully"
        successForSection = "Right Section Format"
        notSuccessForPassword = "Password must be greater than six characters"
    }

    @Test
    fun testStudentSectionMustBeInteger() {
        initValidString()
        onView(withId(R.id.section))
            .perform(typeText(stringToBeTypedInSectionEditText.toString()), closeSoftKeyboard())
        onView(withId(R.id.toast_textview))
            .perform(typeText(successForSection), closeSoftKeyboard())

        onView(withId(R.id.section))
            .check(matches(withText("String which are not allowed in section")))
        onView(withId(R.id.toast_textview))
            .perform(typeText(notSuccessForSection), closeSoftKeyboard())

        onView(withId(R.id.section))
            .check(matches(withText(2)))
        onView(withId(R.id.toast_textview))
            .perform(typeText(successForSection), closeSoftKeyboard())
    }
    @Test
    fun testPasswordMustBeGreaterThanSixCharacter(){
        initValidString()
        onView(withId(R.id.password_edit_text))
            .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
        onView(withId(R.id.toast_textview))
            .perform(typeText(notSuccessForPassword) , closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .check(matches(withText("pass")))
        onView(withId(R.id.toast_textview))
            .perform(typeText(notSuccessForPassword))

        onView(withId(R.id.password_edit_text))
            .check(matches(withText(12345)))
        onView(withId(R.id.toast_textview))
            .perform(typeText(notSuccessForPassword) , closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .check(matches(withText(123456)))
        onView(withId(R.id.toast_textview))
            .perform(typeText(successForPassword), closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .check(matches(withText("pass1234")))
        onView(withId(R.id.toast_textview))
            .perform(typeText(successForPassword) , closeSoftKeyboard())


    }
    @Test
    fun testSuccessMessageWhenAddButtonClicked(){
        initValidString()
        onView(withId(R.id.first_name))
            .perform(typeText(stringToBeTypedInFirstNameEditText), closeSoftKeyboard())
        onView(withId(R.id.last_name))
            .perform(typeText(stringToBeTypedInLastNameEditText), closeSoftKeyboard())

        onView(withId(R.id.section))
            .perform(typeText(stringToBeTypedInSectionEditText.toString()), closeSoftKeyboard())

        onView(withId(R.id.course))
            .perform(typeText(stringToBeTypedInCourseEditText), closeSoftKeyboard())

        onView(withId(R.id.department))
            .perform(typeText(stringToBeTypedInDepartmentEditText), closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .perform(typeText(stringToBeTypedInPasswodEditText), closeSoftKeyboard())
        onView(withId(R.id.add_button))
            .perform(click())
        onView(withText(stringToBeTyped))
            .check(matches(isDisplayed()))
        onView(withId(R.id.toast_textview))
            .perform(typeText(stringToBeTyped))


    }


}