package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bronk3.workouttracker.R
import android.widget.AdapterView
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.MeasurementTypes

class CustomizeWorkoutAdapter(val context: Context, val exersizeList: ArrayList<Exersize>, val onTextChange: (Int, Exersize) -> Unit) :
        RecyclerView.Adapter<CustomizeWorkoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView =
                LayoutInflater.from(context).inflate(R.layout.customize_workout_adapter, parent, false)

        return ViewHolder(inflatedView)
    }

    fun returnCustomizedExersizeList(): ArrayList<Exersize> {
        return exersizeList
    }

    override fun getItemCount(): Int {
        return exersizeList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(context, position, onTextChange)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //Get View Fields
        val exersizeImage = itemView.findViewById<ImageView>(R.id.exersizeImage)
        val repText = itemView.findViewById<EditText>(R.id.repText)
        val setText = itemView.findViewById<EditText>(R.id.setText)
        val weightText = itemView.findViewById<EditText>(R.id.weightText)
        val weightTypeDropDown = itemView.findViewById<Spinner>(R.id.weightTypeText)

        fun bindViewHolder(context: Context, position: Int, onTextChange: (Int, Exersize) -> Unit) {
            val exersize = exersizeList[position]
            val resourceId = context.resources.getIdentifier(exersize.image,
                    "drawable", context.packageName)
            val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,
                    MeasurementTypes.toStringArray())

            // Attach View Fields with Data Fields
            exersizeImage.setImageResource(resourceId)
            repText?.setText(exersize.reps.toString(), TextView.BufferType.EDITABLE)
            setText?.setText(exersize.sets.toString(), TextView.BufferType.EDITABLE)
            weightText?.setText(exersize.measure.toString(), TextView.BufferType.EDITABLE)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            weightTypeDropDown.setAdapter(adapter)
            weightTypeDropDown.setSelection(MeasurementTypes.values().indexOf(exersize.measureType))

            //Data Change Listeners
            repText.addTextChangedListener(TextWatch("rep", exersize, position, onTextChange))
            setText.addTextChangedListener(TextWatch("set", exersize, position, onTextChange))
            weightText.addTextChangedListener(TextWatch("measure", exersize, position, onTextChange))
            weightTypeDropDown.setOnItemSelectedListener(SpinnerListener(exersize, position, onTextChange))
        }
    }
}

class SpinnerListener(
        val exersize: Exersize,
        val exPosition: Int,
        val onTextChange: (Int, Exersize) -> Unit
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
        exersize.measureType = MeasurementTypes.values()[position]
        onTextChange(exPosition, exersize)
    }
    override fun onNothingSelected(parentView: AdapterView<*>) {}
}

class TextWatch(val type: String, val exersize: Exersize, val position: Int, val onTextChange: (Int, Exersize) -> Unit) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        var newNum = 0
        try {
            newNum = s.toString().toInt()
        } catch (e: Exception) {}

        when(type) {
            "rep" -> exersize.reps = newNum
            "set" ->exersize.sets = newNum
            "measure" ->exersize.measure = newNum
            else -> ""
        }
        onTextChange(position, exersize)
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}