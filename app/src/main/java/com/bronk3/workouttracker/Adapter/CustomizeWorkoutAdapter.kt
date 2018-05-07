package com.bronk3.workouttracker.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.getExersizeById
import android.widget.AdapterView
import com.bronk3.workouttracker.Model.Exersize

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

        //Get View Fields
        val exersizeImage = itemView?.findViewById<ImageView>(R.id.exersizeImage)
        val repText = itemView?.findViewById<EditText>(R.id.repText)
        val setText = itemView?.findViewById<EditText>(R.id.setText)
        val weightText = itemView?.findViewById<EditText>(R.id.weightText)
        val weightTypeDropDown = itemView?.findViewById<Spinner>(R.id.weightTypeText)



        fun bindViewHolder(context: Context, holder: ViewHolder, position: Int) {

            val customization = customizations[position]
            val exersize = getExersizeById(customization.ExersizeId)
            val resourceId = context.resources.getIdentifier(exersize?.image,
                    "drawable", context.packageName)
            val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, exersize?.measurementTypes)

            // Attach View Fields with Data Fields
            exersizeImage.setImageResource(resourceId)
            repText?.setText(customization.reps?.toString(), TextView.BufferType.EDITABLE)
            setText?.setText(customization.sets?.toString(), TextView.BufferType.EDITABLE)
            weightText?.setText(customization.measurement?.toString(), TextView.BufferType.EDITABLE)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            weightTypeDropDown.setAdapter(adapter)
            weightTypeDropDown.setSelection(exersize?.measurementTypes!!.indexOf(customization.measurementType))

            //Data Change Listeners
            repText.addTextChangedListener(TextWatch("rep", customization))
            setText.addTextChangedListener(TextWatch("set", customization))
            weightText.addTextChangedListener(TextWatch("measure", customization))
            weightTypeDropDown.setOnItemSelectedListener(SpinnerListener(customization, exersize))
        }
    }
}

class SpinnerListener(val customization: Customization, val exersize: Exersize?) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
        customization.measurementType = exersize?.measurementTypes!![position]
    }

    override fun onNothingSelected(parentView: AdapterView<*>) {}

}

class TextWatch(val type: String, val customization: Customization) : TextWatcher {

    override fun afterTextChanged(s: Editable?) {
        when(type) {
            "rep" -> customization.reps = s.toString().toIntOrNull()
            "set" ->customization.sets = s.toString().toIntOrNull()
            "measure" ->customization.measurement = s.toString().toIntOrNull()
            else -> ""
        }
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}