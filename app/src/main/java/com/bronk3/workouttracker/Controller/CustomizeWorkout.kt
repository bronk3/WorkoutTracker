package com.bronk3.workouttracker.Controller

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import com.bronk3.workouttracker.Adapter.CustomizeWorkoutAdapter
import com.bronk3.workouttracker.Model.*
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.*
import kotlinx.android.synthetic.main.activity_customize_workout.*

class CustomizeWorkout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_workout)

        //Extras
        val workout = intent.getParcelableExtra<Workout>(WORKOUT)

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
        val adapter = CustomizeWorkoutAdapter(this, ExersizeCollection.database)
        editWorkout.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this)
        editWorkout.layoutManager = linearLayoutManager
        editWorkout.setHasFixedSize(true)

        // Save Customization
        submitEditChanges.setOnClickListener {
            val intent = Intent(this, WorkoutMain::class.java)
            startActivity(intent)
        }
    }
}
