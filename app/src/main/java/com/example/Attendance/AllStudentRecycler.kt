package com.example.Attendance


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.Attendance.data.Student
import com.example.Attendance.viewmodel.StudentViewModel

class AllStudentRecycler : Fragment() {
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var students: List<Student>
    private lateinit var studentFirstName: TextView
    private lateinit var studentLastName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        //here I am stoping
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_all_student_recycler, container, false)
    }


}
