package com.bronk3.workouttracker.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bronk3.workouttracker.Adapter.CustomizeWorkoutAdapter
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.*
import kotlinx.android.synthetic.main.activity_customize_workout.*

class CustomizeWorkout : AppCompatActivity() {

    lateinit var workout: Workout
    var customizationList = ArrayList<Customization>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_workout)

        // Edit Workout
        val workout_id = intent.getIntExtra(WORKOUT_ID, 0)
        if(workout_id != 0) {
            workout = getWorkoutById(workout_id)
            customizationList = getCustomizationByWorkoutId(workout_id)
        }
        //Create New Workout
        val exersizeIdList = intent.getIntegerArrayListExtra(EXERSIZE_ID_LIST)
        if(exersizeIdList != null) {
            customizationList = createCustomizationListByExerciseIds(workout_id, exersizeIdList)
        }

        editWorkout.adapter = CustomizeWorkoutAdapter(this, customizationList)
        editWorkout.layoutManager = LinearLayoutManager(this)
        editWorkout.setHasFixedSize(true)

        submitEditChanges.setOnClickListener {
            // Save to Workout
            val intent = Intent(this, WorkoutMain::class.java)
            startActivity(intent)
        }
    }
}
