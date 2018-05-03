package com.bronk3.workouttracker.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bronk3.workouttracker.Adapter.WorkoutAdapter
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Services.DataSet.workouts
import com.bronk3.workouttracker.Utility.WORKOUT_ID
import kotlinx.android.synthetic.main.activity_main.*

class WorkoutMain : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ViewHolder Adapter onClicked Item Funcion
        val workoutClicked = {
            workout: Workout ->
            println(workout)
            val editWorkoutIntent = Intent(this, CustomizeWorkout::class.java)
            editWorkoutIntent.putExtra(WORKOUT_ID, workout.id)
            startActivity(editWorkoutIntent)
        }

        workoutList.setHasFixedSize(true)
        workoutList.layoutManager = LinearLayoutManager(this)
        workoutList.adapter = WorkoutAdapter(this, workouts, workoutClicked)


        //Add Button
        addWorkoutBtn.setOnClickListener { view ->
            var addWorkout = Intent(this, CreateWorkout::class.java)
            startActivity(addWorkout)
        }

    }
}
