package com.example.Attendance

import androidx.fragment.app.Fragment


/**
 * A host (typically an `Activity`} that can display fragments and knows how to respond to
 * navigation events.
 */
interface NavigationHost {

   fun navigateTo(fragment: Fragment, addToBackstack: Boolean)
}
