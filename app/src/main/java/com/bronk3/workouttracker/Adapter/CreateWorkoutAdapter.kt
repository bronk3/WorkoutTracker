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


class CreateWorkoutAdapter(val context: Context, val exersizeList: Array<Exersize>, val itemClick: (Exersize) -> Boolean)
    : RecyclerView.Adapter<CreateWorkoutAdapter.ViewHolder>() {

    val selectedExersizeArray = BooleanArray(exersizeList.count()){ position -> false }

    fun returnSelectedExersizeArray(): BooleanArray {
        return selectedExersizeArray
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflator
        val view = LayoutInflater.from(context).inflate(R.layout.create_workout_adapter, parent, false)
        // return ViewHolder
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exersizeList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindViewHolder(context, position, itemClick)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        println(selectedExersizeArray)
    }

    override fun registerAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        println("who dun it")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.exersizeImage)
        val name = itemView.findViewById<TextView>(R.id.exersizeName)

        fun BindViewHolder (context: Context, position: Int, itemClick: (Exersize) -> Boolean) {
            val exersize = exersizeList[position]
            val resourceId = context.resources.getIdentifier(exersize.image, "drawable", context.packageName)
            image.setImageResource(resourceId)
            name.text = exersize.name.Name
            itemView.setTag( exersize)

            itemView.setOnClickListener { view ->
                if(!view.isSelected) {
                    selectedExersizeArray[2]
                    view.isSelected = true
                    view.setBackgroundResource(R.color.colorPrimary)
                    name.setTextColor(Color.WHITE)
                } else {
                    view.isSelected = false
                    view.setBackgroundColor(Color.TRANSPARENT)
                    name.setTextColor(R.color.colorPrimaryDark.absoluteValue)
                }
                itemClick(view.getTag() as Exersize)
            }
        }
    }

}