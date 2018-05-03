package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.getDate

class WorkoutAdapter(val context: Context, val workouts: ArrayList<Workout>, val itemClicked: (Workout) -> Unit)
    : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate a view
        val view = LayoutInflater.from(context).inflate(R.layout.workout_main_adapter, parent, false)
        //return view wrapped in inner class ViewHolder
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //return given array
      return workouts.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindWorkout(context, position, itemClicked)
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        // create view items
        var nameLbl = itemView?.findViewById<TextView>(R.id.workoutName)
        var timestampLbl = itemView?.findViewById<TextView>(R.id.workoutTimeStamp)

        // bind view items
        fun bindWorkout(context: Context, position: Int, itemClick: (Workout) -> Unit) {
            var current = workouts[position]
            nameLbl?.text = current.name.toUpperCase()
            timestampLbl?.text = current.timeStamp

            itemView.setOnClickListener {
                current.timeStamp = getDate()
                timestampLbl?.text = current.timeStamp
                itemClick(current)
            }
        }
    }
}