package com.example.swipe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swipe.databinding.ItemLayoutBinding
import com.example.swipe.model.model

class CourseRvAdapter(private val courseList:ArrayList<model>,private val context: Context) : RecyclerView.Adapter<CourseRvAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPosition=courseList[position]
        holder.binding.idTVName.text=currentPosition.name
        holder.binding.idIVImage.setImageResource(currentPosition.img)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

}
