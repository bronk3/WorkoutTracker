package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.R

class CustomizeWorkoutAdapter(val context: Context, val customizations: ArrayList<Customization>) :
        RecyclerView.Adapter<CustomizeWorkoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView =
                LayoutInflater.from(context).inflate(R.layout.customize_workout_adapter, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return customizations.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(context, holder, position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val repText = itemView?.findViewById<EditText>(R.id.repText)
        val setText = itemView?.findViewById<EditText>(R.id.setText)
        val weightText = itemView?.findViewById<EditText>(R.id.weightText)
        val weightTypeText = itemView?.findViewById<Spinner>(R.id.weightTypeText)

        fun bindViewHolder(context: Context, holder: ViewHolder, position: Int) {
            val customization = customizations[position]
            repText?.setText(customization.reps?.toString(), TextView.BufferType.EDITABLE)
            setText?.setText(customization.sets?.toString(), TextView.BufferType.EDITABLE)
            weightText?.setText(customization.measurement?.toString(), TextView.BufferType.EDITABLE)
        }
    }
}