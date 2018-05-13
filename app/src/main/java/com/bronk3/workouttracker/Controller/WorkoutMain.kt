package com.bronk3.workouttracker.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bronk3.workouttracker.Adapter.WorkoutAdapter
import com.bronk3.workouttracker.Model.ExersizeCollection
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Model.WorkoutCollection
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.WORKOUT
import com.bronk3.workouttracker.Utility.WORKOUT_ID
import kotlinx.android.synthetic.main.activity_main.*

class WorkoutMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  println(ExersizeCollection.HistoryDatabase.count())

        //Create Workout
        addWorkoutBtn.setOnClickListener { view ->
            val createWorkout = Intent(this, CreateWorkout::class.java)
            startActivity(createWorkout)
        }

        //Do Workout
        val doClick = { workout: Workout, position: Int ->
            val doWorkout = Intent(this, DoWorkout::class.java)
            doWorkout.putExtra(WORKOUT, workout)
            doWorkout.putExtra(WORKOUT_ID, position)
            startActivity(doWorkout)
        }

        //Customize Workout
        val editClick = { workout: Workout, position: Int ->
            val intent = Intent(this, CustomizeWorkout::class.java)
            intent.putExtra(WORKOUT, workout)
            intent.putExtra(WORKOUT_ID, position)
            startActivity(intent)
        }

        //Show Workout list
        workoutList.setHasFixedSize(true)
        workoutList.layoutManager = LinearLayoutManager(this)
        workoutList.adapter = WorkoutAdapter(this, WorkoutCollection.database, doClick, editClick)
    }
}
