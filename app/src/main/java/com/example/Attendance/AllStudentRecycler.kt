package com.example.Attendance


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Attendance.data.Student
import com.example.Attendance.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_all_student_recycler.view.*

class AllStudentRecycler : Fragment() {
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var recyclerView: RecyclerView
    //private lateinit var students: List<Student>
    //private lateinit var studentFirstName: TextView
    //private lateinit var studentLastName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view=inflater.inflate(R.layout.fragment_all_student_recycler, container, false)
        recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        studentViewModel.getAllStudents().observe(this, Observer{

            recyclerView.adapter=StudentRecyclerAdapter(it)
        })


        return view
    }


}
