package com.example.swipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.swipe.databinding.ActivityMainBinding
import com.example.swipe.model.model
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView :RecyclerView
    lateinit var Courseadapter: CourseRvAdapter
    lateinit var courseList:ArrayList<model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView=binding.recyclerView
        courseList=ArrayList()
        Courseadapter=CourseRvAdapter(courseList,this)
        recyclerView.adapter=Courseadapter

        courseList.add(model("C",R.drawable.ic_c))
        courseList.add(model("Java",R.drawable.ic_java))
        courseList.add(model("Python",R.drawable.ic_python))
        courseList.add(model("JavaScript",R.drawable.ic_javascript))
        courseList.add(model("Android",R.drawable.ic_android))

        Courseadapter.notifyDataSetChanged()

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedCourse:model = courseList.get(viewHolder.adapterPosition)

                val position=viewHolder.adapterPosition

                courseList.removeAt(viewHolder.adapterPosition)

                Courseadapter.notifyItemRemoved(viewHolder.adapterPosition)

                Snackbar.make(recyclerView,"Deleted "+ deletedCourse.name, Snackbar.LENGTH_LONG)
                    .setAction(
                        "undo",
                        View.OnClickListener {
                            courseList.add(position,deletedCourse)

                            Courseadapter.notifyItemInserted(position)
                        }).show()

            }

        }).attachToRecyclerView(recyclerView)





    }
}