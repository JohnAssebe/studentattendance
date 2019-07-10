package com.example.Attendance


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Attendance.data.Attendance
import com.example.Attendance.data.Student
import com.example.Attendance.viewmodel.AttendanceViewModel
import com.example.Attendance.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.all_students_recycler_viewitem.*
import kotlinx.android.synthetic.main.all_students_recycler_viewitem.view.*
import kotlinx.android.synthetic.main.fragment_all_student_recycler.view.*

class AllStudentRecycler : Fragment() {
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var attendanceViewModel: AttendanceViewModel
    private lateinit var studentViewModelCachedViewModel:StudentRoomViewModel
    private lateinit var recyclerView: RecyclerView
//    private lateinit var FirstName:TextView
//    private lateinit var LastName:TextView
//    private lateinit var Status:CheckBox
//    private lateinit var date:String
    //private lateinit var students: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        attendanceViewModel=ViewModelProviders.of(this).get(AttendanceViewModel::class.java)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view=inflater.inflate(R.layout.fragment_all_student_recycler, container, false)
        //val activity = activity as MainActivity?
        //val isConnected = activity?.connected()
//        FirstName=view.student_first_name
//        LastName=view.student_last_name
//        Status=view.check_box_present

        recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        studentViewModel.getAllStudents().observe(this, Observer{

            recyclerView.adapter=StudentRecyclerAdapter(it,attendanceViewModel,studentViewModelCachedViewModel)
        })
//        ,{Attendance(
//
//            FirstName.text.toString(),
//            LastName.text.toString(),
//            Status.isChecked,
//            date
//        )}
//        studentFirstName=view.student_first_name.toString()
//        studentLastName=view.student_last_name.toString()
//        studentStatus=view.check_box_present.isSelected
//
//        view.check_box_present.setOnClickListener{
//     if(check_box_present.isChecked){
//            if(isConnected!!){
//                attendanceViewModel.AddAttendance(readFields())
//                //clearFields()
//
//            }
//     }
//

//        }
        return view

    }
//    private fun readFields() = Attendance(
//
//        FirstName.text.toString(),
//        LastName.text.toString(),
//        Status.isChecked,
//        date
//    )

//    private fun clearFields() {
//        studentFirstName
//        studentLastName.setText("")
//        studentStatus.setText("")
//    }


}
