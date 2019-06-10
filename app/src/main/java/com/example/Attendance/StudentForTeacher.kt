package com.example.Attendance


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.example.Attendance.R
import com.example.Attendance.data.Student
import com.example.Attendance.viewmodel.StudentViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_student_for_teacher.*
import kotlinx.android.synthetic.main.fragment_student_for_teacher.view.*


class StudentForTeacher : Fragment() {
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var firstName: EditText
    private lateinit var lastName:EditText
    private lateinit var course:EditText
    private lateinit var section:EditText
    private lateinit var department:EditText
    private lateinit var  password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_student_for_teacher, container, false)
        val activity = activity as MainActivity?
        val isConnected = activity?.connected()
        firstName=view.first_name
        lastName=view.last_name
        course=view.course
        section=view.section
        department=view.department
        password=view.password_edit_text
            view.add_button.setOnClickListener{
                if(isConnected!!){
                    studentViewModel.AddStudent(readFields())
                    clearFields()
                }
            }
        return view
    }
    private fun readFields() = Student(
    id, firstName.text.toString(),
    lastName.text.toString(),
    course.text.toString(),
    section.text.toString(),
    department.text.toString(),
    password.text.toString()
    )

    private fun clearFields() {
        firstName.setText("")
        lastName.setText("")
        course.setText("")
        section.setText("")
        department.setText("")
        password.setText("")
    }
}


