package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.getExersizeById


class DoWorkoutAdapter(val context: Context, val customizations: ArrayList<Customization>)
    : RecyclerView.Adapter<DoWorkoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.do_workout_adapter, parent, false)
        var buttonLayout = LayoutInflater.from(context).inflate(R.layout.do_workout_set_button, null)
        Log.d("view", "Create View $viewType")
        return ViewHolder(layout, buttonLayout)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        Log.d("view", holder.toString())
        Log.d("view",holder.setContainer.toString())
    }

    override fun onFailedToRecycleView(holder: ViewHolder): Boolean {
        Log.d("view", holder.toString())
        Log.d("view",holder.setContainer.toString())
        return super.onFailedToRecycleView(holder)
    }

    override fun getItemCount(): Int {
        return customizations.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindViewHolder(context, position)
    }

    inner class ViewHolder(itemView: View, buttonView: View) : RecyclerView.ViewHolder(itemView) {
        val setContainer = itemView.findViewById<LinearLayout>(R.id.setContainer)
        val image = itemView.findViewById<ImageView>(R.id.exersizeImage)
        val exersizeWeightText = itemView.findViewById<TextView>(R.id.exersizeWeightText)

//        val buttonView1 = buttonView
//        val buttonNumber = buttonView.findViewById<TextView>(R.id.setButtonText)


        fun BindViewHolder(context: Context, position: Int) {
            Log.d("view", "bind view $position")
            val customization = customizations[position]
            val exersize = getExersizeById(customization.ExersizeId)
            val setNumber = customization.sets
            val repNumber = customization.reps
            val resource = context.resources.getIdentifier(exersize?.image, "drawable", context.packageName)
            image.setImageResource(resource)
            if(customization.measurement != null && customization.measurementType != "N/A") {
                exersizeWeightText.text = "${customization.measurement} ${customization.measurementType}"
            }
            var i = 0

            if(setNumber != null) {
                setContainer.setHasTransientState(true)
                while( i < setNumber) {
                    /*This is heavy need to find a way not to get the error:
                     java.lang.IllegalStateException: The specified child already has a parent.
                     You must call removeView() on the child's parent first.
                        when trying to use a copy of a inflated layout - buttonView1
                    */
                    val setButton = LayoutInflater.from(context).inflate(R.layout.do_workout_set_button, null)
                    Log.d("view", "Create set button ${setButton.id}")
                    val setButtonNumber = setButton.findViewById<TextView>(R.id.setButtonText)
                    setButtonNumber.setTag(repNumber)
                    setButtonNumber.text = repNumber.toString()

                    //Click Set Button
                    setButton.setOnClickListener { setButtonClick: View ->
                        val circleBtn = setButtonClick.findViewById<ImageView>(R.id.setButton)
                        val textBtn = setButtonClick.findViewById<TextView>(R.id.setButtonText)
                        if(!setButtonClick.isSelected) {
                            textBtn.text = ""
                            textBtn.background = ContextCompat.getDrawable(context, R.drawable.ic_check_white_24dp)
                            (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorPink))
                            setButtonClick.isSelected = true
                        } else {
                            textBtn.text = textBtn.getTag().toString()
                            textBtn.background = null
                            (circleBtn.drawable as GradientDrawable)?.setColor(ContextCompat.getColor(context, R.color.colorGrey))
                            setButtonClick.isSelected = false
                        }
                    }
                    setContainer.addView(setButton)
                    i++
                }
                setContainer.setHasTransientState(false)
            }
        }
    }
}