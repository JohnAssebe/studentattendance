package com.example.Attendance

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.mockito.Mockito
import java.util.regex.Matcher
import java.util.regex.Pattern.matches

@Test
fun testLoginTo_AddStudent(){
    val mockNavController = Mockito.mock(NavController::class.java)

    val givenScenario = launchFragmentInContainer<LoginFragment>()
    givenScenario.onFragment { fragment ->
        Navigation.setViewNavController(fragment.login_fragment(), mockNavController)
        val activityScenario = ActivityScenario.launch(LoginFragment::class.java)
        dataBindingIdLingResource.monitorActivity(activityScenario)

        onView(withId(R.id.login_button)).perform(click())

        Mockito.verify(mockNavController).navigate(R.id.home_fragment)
       onView(withId(R.id.student_card_view)).perform(click())
        Mockito.verify(mockNavController).navigate(R.id.student_fragment)

        onView(withId(R.id.first_name)).perform(typeText("First Name"), closeSoftKeyboard())
        onView(withId(R.id.last_name)).perform(typeText("Last Name"), closeSoftKeyboard())
        onView(withId(R.id.section)).perform(typeText("03"), closeSoftKeyboard())
        onView(withId(R.id.department)).perform(typeText("Software"), closeSoftKeyboard())
        onView(withId(R.id.course)).perform(typeText("Android"), closeSoftKeyboard())
        onView(withId(R.id.password_edit_text)).perform(typeText("Password"), closeSoftKeyboard())
        onView(withId(R.id.add_button)).perform(click())

        onView(withText("Student Added Successfully")).check(matches(isDisplayed()))
        







    }

}

fun matches(displayed: Matcher<View>?): Boolean {

}
