package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter (val list: List<TodoModel>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_todo,parent,false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() =list.size

    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: TodoModel){
            with(itemView){
                val colors = resources.getIntArray(R.array.random_color)
                val randomColor =colors[Random().nextInt(colors.size)]
                viewColorTag.setOnClickListener { randomColor }
                txtshowtitle.text=todoModel.title
                txtshowtask.text = todoModel.description
                txtshowcategory.text =todoModel.category
                updateTime(todoModel.time)
                updateDate(todoModel.date)
            }
        }

        private fun updateTime(time: Long) {

            val myformat= "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtshowTime.text = sdf.format(Date(time))
        }

        private fun updateDate(time: Long) {

            val myformat= "EEE, d MMM yyyy"
            val sdf =SimpleDateFormat(myformat)
            itemView.txtshowDate.text = sdf.format(Date(time))
        }

    }

}