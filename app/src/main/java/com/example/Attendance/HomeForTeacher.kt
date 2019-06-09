package com.example.Attendance
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home_for_teacher.view.*

class HomeForTeacher : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home_for_teacher, container, false)
        val activity = activity as MainActivity?
        view.student_card_view.setOnClickListener{
            (activity as NavigationHost).navigateTo(StudentForTeacher(), false)


        }
        view.attendance_card_view.setOnClickListener{
            (activity as NavigationHost).navigateTo(AllStudentRecycler(), false)
        }


        return view
    }


}
