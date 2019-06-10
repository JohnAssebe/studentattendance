package com.example.Attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.Attendance.viewmodel.TeacherViewModel
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginFragment: Fragment() {
    private lateinit var teacherViewModel: TeacherViewModel
    private lateinit var username:EditText
    private lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teacherViewModel= ViewModelProviders.of(this).get(TeacherViewModel::class.java)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        val activity = activity as MainActivity?
        username=view.user_name
        password=view.password_edit_text
        view.login_button.setOnClickListener {
           teacherViewModel.AllTeachers().observe(this, Observer {



           })
            (activity as NavigationHost).navigateTo(HomeForTeacher(), false)
        }


        return view
    }
}