package com.bronk3.workouttracker.Controller

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import com.bronk3.workouttracker.Adapter.CustomizeWorkoutAdapter
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.CustomizationCollection.createCustomizationList
import com.bronk3.workouttracker.Model.CustomizationCollection.updateCustomizationList
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Model.WorkoutCollection
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.*
import kotlinx.android.synthetic.main.activity_customize_workout.*

class CustomizeWorkout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_workout)

        //Extras
        val workout = intent.getParcelableExtra<Workout>(WORKOUT)
        val exersizeList = intent.getParcelableArrayListExtra<Exersize>(EXERSIZE_LIST)
        var customizationList = createCustomizationList(exersizeList, workout)

        //View
        workoutName.setText(workout.name)
        workoutName.setOnClickListener { view: View ->

            var builder = AlertDialog.Builder(this)
            var layout = layoutInflater.inflate(R.layout.workout_name_alert, null)

            builder.setView(layout)
                    .setPositiveButton("Ok") { _, _ ->
                        val dialogWorkoutName = layout.findViewById<EditText>(R.id.dialogWorkoutName)
                        workout.name = dialogWorkoutName.text.toString()
                        workoutName.setText(workout.name)
                    }
                    .setNegativeButton("Cancel") { _, _ ->

                    }.show()
        }

        //Adapter
        val adapter = CustomizeWorkoutAdapter(this, customizationList)
        editWorkout.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this)
        editWorkout.layoutManager = linearLayoutManager
        editWorkout.setHasFixedSize(true)

        // Save Customization
        submitEditChanges.setOnClickListener {
            updateCustomizationList(customizationList)
            val intent = Intent(this, WorkoutMain::class.java)
            startActivity(intent)
        }
    }
}
