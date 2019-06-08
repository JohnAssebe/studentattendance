package com.example.Attendance

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.Attendance.data.Teacher
import com.example.Attendance.viewmodel.TeacherViewModel

import kotlinx.android.synthetic.main.register_fragment.view.*

class RegisterFragment: Fragment() {

    private lateinit var teacherViewModel: TeacherViewModel
    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var courseEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teacherViewModel = ViewModelProviders.of(this).get(TeacherViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.register_fragment, container, false)

        val activity = activity as MainActivity?
        val isConnected = activity?.connected()

        /////
        userNameEditText = view.register_username_edit_text

        passwordEditText = view.register_password_edit_text
        courseEditText = view.course_edit_text

        /////


        view.back_button.setOnClickListener {
            (activity as NavigationHost).navigateTo(LoginFragment(), false) // Navigate to the next Fragment
        }

        view.register_button.setOnClickListener {
            if(isConnected!!){
                teacherViewModel.AddTeacher(readFields())
                clearFields()
            }

        }


        return view
    }


    private fun readFields() = Teacher(
        0,
        userNameEditText.text.toString(),
        passwordEditText.text.toString(),
        courseEditText.text.toString()
    )

    private fun clearFields() {
        userNameEditText.setText("")
        passwordEditText.setText("")
        courseEditText.setText("")
    }
}
