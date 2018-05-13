package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.ExersizeCollection
import com.bronk3.workouttracker.Model.MeasurementTypes
import com.bronk3.workouttracker.R
import java.util.*


class DoWorkoutAdapter(
        val context: Context,
        val exersizeList: ArrayList<Exersize>,
        val onSetClick: (Int, Int, Boolean, Boolean) -> BooleanArray,
        val onWorkoutComplete: () -> Unit)
    : RecyclerView.Adapter<DoWorkoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.do_workout_adapter, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return exersizeList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindViewHolder(context, position, onSetClick, onWorkoutComplete)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val setContainer = itemView.findViewById<LinearLayout>(R.id.setContainer)
        val image = itemView.findViewById<ImageView>(R.id.exersizeImage)
        val exersizeWeightText = itemView.findViewById<TextView>(R.id.exersizeWeightText)

        fun BindViewHolder(
                context: Context,
                position: Int,
                onSetClick: (Int, Int, Boolean, Boolean) -> BooleanArray,
                onWorkoutComplete: () -> Unit) {
            val exersize = exersizeList[position]
            val setNumber = exersize.sets
            val repNumber = exersize.reps
            val resource = context.resources.getIdentifier(exersize?.image, "drawable", context.packageName)
            image.setImageResource(resource)
            if(exersize.measureType != MeasurementTypes.NA) {
                exersizeWeightText.text = "${exersize.measure} ${exersize.measureType}"
            }

            var i = 0

            if(setNumber != null) {
                while( i < setNumber) {
                    val setButton = LayoutInflater.from(context).inflate(R.layout.do_workout_set_button, null)
                    val circleBtn = setButton.findViewById<ImageView>(R.id.setButton)
                    val textBtn = setButton.findViewById<TextView>(R.id.setButtonText)
                    textBtn.setTag(repNumber)
                    textBtn.text = repNumber.toString()
                    setButton.setTag(i)
                    if (exersize.workoutSetState[i]) {
                        textBtn.text = ""
                        textBtn.background = ContextCompat.getDrawable(context, R.drawable.ic_check_white_24dp)
                        (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorPink))
                    } else {
                        textBtn.text = textBtn.getTag().toString()
                        textBtn.background = null
                        (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorGrey))
                    }

                    //Click Set Button
                    setButton.setOnClickListener { setButtonClick: View ->
                        val circleBtn = setButtonClick.findViewById<ImageView>(R.id.setButton)
                        val textBtn = setButtonClick.findViewById<TextView>(R.id.setButtonText)
                        val i = setButton.getTag() as Int
//                        toggleSetButton(exersize.workoutSetState[i], textBtn, circleBtn, exersize, position, i)
                        var inProgress = exersize.workoutSetState.contains(false)
                        if(!exersize.workoutSetState[i]) {
                            textBtn.text = ""
                            textBtn.background = ContextCompat.getDrawable(context, R.drawable.ic_check_white_24dp)
                            (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorPink))
                            exersize.workoutSetState = onSetClick(position, i, true, !inProgress)
                            if(!inProgress) {
                                exersize.complete = 1
                                Toast.makeText(context, "Congrats!", Toast.LENGTH_SHORT).show()
                                onWorkoutComplete()
                            }
                        } else {
                            textBtn.text = textBtn.getTag().toString()
                            textBtn.background = null
                            (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorGrey))
                            exersize.workoutSetState = onSetClick(position, i, false, false)
                        }
                    }
                    setContainer.addView(setButton)
                    i++
                }
            }
        }
    }
}