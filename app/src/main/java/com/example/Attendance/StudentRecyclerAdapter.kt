package com.example.Attendance
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Attendance.data.Student

class StudentRecyclerAdapter(private var students: List<Student>):
    RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {
    override fun getItemCount(): Int {
        return students.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = inflater.inflate(R.layout.all_students_recycler_viewitem,parent,false)
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
        var studenfirsttName: TextView = studentView.findViewById(R.id.student_first_name)
        var studentlastName: TextView = studentView.findViewById(R.id.student_last_name)

    }
}