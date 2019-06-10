package com.example.Attendance
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.Attendance.data.Attendance
import com.example.Attendance.data.Student
import com.example.Attendance.viewmodel.AttendanceViewModel
import com.example.Attendance.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.all_students_recycler_viewitem.view.*
class StudentRecyclerAdapter(private var students: List<Student>,private var attendanceviewmodel:AttendanceViewModel):
    RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {
    override fun getItemCount(): Int {
        return students.size
    }
    private lateinit var FirstName:TextView
    private lateinit var LastName:TextView
    private lateinit var Status: CheckBox
    private  var date:String="1/2/3"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = inflater.inflate(R.layout.all_students_recycler_viewitem,parent,false)
        FirstName=recyclerViewItem.student_first_name
        LastName=recyclerViewItem.student_last_name
        Status=recyclerViewItem.check_box_present
        return StudentViewHolder(recyclerViewItem)
    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        val studentAtPosition= students[position]
        holder.studenfirsttName.text = studentAtPosition.first_name
        holder.studentlastName.text = studentAtPosition.last_name

    }
    fun setData(newStudent:List<Student>){
        this.students = newStudent
        notifyDataSetChanged()
    }
    inner class StudentViewHolder(studentView: View): RecyclerView.ViewHolder(studentView) {
        init{
            studentView.setOnClickListener {
                attendanceviewmodel.AddAttendance(readFields())
            }
        }
        var studenfirsttName: TextView = studentView.findViewById(R.id.student_first_name)
        var studentlastName: TextView = studentView.findViewById(R.id.student_last_name)

    }
    private fun readFields() = Attendance(

        FirstName.text.toString(),
        LastName.text.toString(),
        Status.isChecked,
        date
    )

}