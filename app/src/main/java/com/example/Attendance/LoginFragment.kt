package com.example.Attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)

        val activity = activity as MainActivity?


        view.login_button.setOnClickListener {
            (activity as NavigationHost).navigateTo(HomeForTeacher(), false)
        }


        return view
    }
}