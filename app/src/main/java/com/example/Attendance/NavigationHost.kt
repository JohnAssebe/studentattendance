package com.example.Attendance

import androidx.fragment.app.Fragment
interface NavigationHost {

   fun navigateTo(fragment: Fragment, addToBackstack: Boolean)
}
