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
import com.bronk3.workouttracker.Model.MeasurementTypes
import com.bronk3.workouttracker.R
import java.util.*


class DoWorkoutAdapter(val context: Context, val exersizeList: ArrayList<Exersize>)
    : RecyclerView.Adapter<DoWorkoutAdapter.ViewHolder>() {


    //Save State between activities
    lateinit var workoutSetState: List<ArrayList<Boolean>>

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        workoutSetState = List(exersizeList.count(), { index: Int ->
            var exersize = exersizeList[index]
            var setLength = exersize.sets
            if (setLength == null)
                    setLength = 0
            var arr = ArrayList<Boolean>()
            for (i in 0..setLength-1) {
                arr.add(false)
            }
            arr
        })
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.do_workout_adapter, parent, false)
        var buttonLayout = LayoutInflater.from(context).inflate(R.layout.do_workout_set_button, null)
        return ViewHolder(layout, buttonLayout)
    }

    override fun getItemCount(): Int {
        return exersizeList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindViewHolder(context, position)
    }

    inner class ViewHolder(itemView: View, buttonView: View) : RecyclerView.ViewHolder(itemView) {
        val setContainer = itemView.findViewById<LinearLayout>(R.id.setContainer)
        val image = itemView.findViewById<ImageView>(R.id.exersizeImage)
        val exersizeWeightText = itemView.findViewById<TextView>(R.id.exersizeWeightText)

        fun BindViewHolder(context: Context, position: Int) {
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
                    var isSelectedText = ""
                    if (workoutSetState[position][i]) {
                         isSelectedText =  "is selected"
                        textBtn.text = ""
                        textBtn.background = ContextCompat.getDrawable(context, R.drawable.ic_check_white_24dp)
                        (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorPink))
                    } else {
                        textBtn.text = textBtn.getTag().toString()
                        textBtn.background = null
                        (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorGrey))
                    }

                    Log.d("view", "On Click Listener: " +
                            "${position}_${i}_${isSelectedText}_${(circleBtn.drawable as GradientDrawable)?.color.defaultColor}")

                    //Click Set Button
                    setButton.setOnClickListener { setButtonClick: View ->
                        val circleBtn = setButtonClick.findViewById<ImageView>(R.id.setButton)
                        val textBtn = setButtonClick.findViewById<TextView>(R.id.setButtonText)
                        val i = setButton.getTag() as Int
                        if(!workoutSetState[position][i]) {
                            textBtn.text = ""
                            textBtn.background = ContextCompat.getDrawable(context, R.drawable.ic_check_white_24dp)
                            (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorPink))
                            workoutSetState[position][i] = true
                        } else {
                            textBtn.text = textBtn.getTag().toString()
                            textBtn.background = null
                            (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorGrey))
                            workoutSetState[position][i] = false
                        }
                        val isSelectedText = if(workoutSetState[position][setButton.getTag() as Int]) "is selected" else "not selected"
                        Log.d("view", "On Click Listener: ${position}_${setButtonClick.getTag()}_$isSelectedText" +
                                "_${(circleBtn.drawable as GradientDrawable)?.color.defaultColor}")

                        var list = workoutSetState[position]
                        var complete = list.contains(false)
                        if(!complete) {
                            Toast.makeText(context, "Congrats!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    setContainer.addView(setButton)
                    i++
                }
            }
        }
    }
}