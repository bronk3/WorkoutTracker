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

    lateinit var adapter: CustomizeWorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_workout)

        //Extras
        val workout = intent.getParcelableExtra<Workout>(WORKOUT)
        val workoutId = intent.getIntExtra(WORKOUT_ID, 0)

        var onTextChange = { exPos: Int, updateValue: Exersize  ->
            WorkoutCollection.database[workoutId].ExersizeList!![exPos].update(updateValue)
        }

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
        //Show Edit Exercises
        adapter = CustomizeWorkoutAdapter(this, workout.ExersizeList!!, onTextChange)
        editWorkout.adapter = adapter
        editWorkout.layoutManager = LinearLayoutManager(this)
        editWorkout.setHasFixedSize(true)

        // Save Customization
        submitEditChanges.setOnClickListener {
            WorkoutCollection.database[workoutId].ExersizeList!!.update(adapter.returnCustomizedExersizeList())
            val intent = Intent(this, WorkoutMain::class.java)
            startActivity(intent)
        }
    }
}
