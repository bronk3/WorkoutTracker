package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.R
import kotlin.math.absoluteValue


class CreateWorkoutAdapter(val context: Context, val exersizes: ArrayList<Exersize>, val itemClick: (Exersize, HashMap<Int, Int>) -> Unit)
    : RecyclerView.Adapter<CreateWorkoutAdapter.ViewHolder>() {

    var selectedIds = hashMapOf<Int, Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflator
        val view = LayoutInflater.from(context).inflate(R.layout.create_workout_adapter, parent, false)
        // return ViewHolder
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exersizes.count()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindViewHolder(context, position, itemClick)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.exersizeImage)
        val name = itemView.findViewById<TextView>(R.id.exersizeName)

        fun BindViewHolder (context: Context, position: Int, itemClick: (Exersize, HashMap<Int, Int>) -> Unit) {
            val current = exersizes[position]
            val resourceId = context.resources.getIdentifier(current.image, "drawable", context.packageName)
            image.setImageResource(resourceId)
            name.text = current.name
            itemView.setTag(current.id)

            itemView.setOnClickListener { view ->
                println(current)
                println(view.getTag())
                if(!view.isSelected) {
                    view.isSelected = true
                    selectedIds.put(position, view.getTag() as Int)
                    view.setBackgroundResource(R.color.colorPrimary)
                    name.setTextColor(Color.WHITE)
                } else {
                    view.isSelected = false
                    selectedIds.remove(position)
                    view.setBackgroundColor(Color.TRANSPARENT)
                    name.setTextColor(R.color.colorPrimaryDark.absoluteValue)
                }
                itemClick(current, selectedIds)
            }
        }
    }

}