package com.bronk3.workouttracker.Controller

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import com.bronk3.workouttracker.Adapter.WorkoutAdapter
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Services.DataSet.workouts
import com.bronk3.workouttracker.Utility.WORKOUT_ID
import kotlinx.android.synthetic.main.activity_customize_workout.*
import kotlinx.android.synthetic.main.activity_main.*

class WorkoutMain : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ViewHolder Adapter onClicked Item Funcion
        val workoutClicked = {
            workout: Workout ->

            //Edit
//            val editWorkoutIntent = Intent(this, CustomizeWorkout::class.java)
//            editWorkoutIntent.putExtra(WORKOUT_ID, workout.id)
//            startActivity(editWorkoutIntent)

            val doWorkout = Intent(this, DoWorkout::class.java)
            doWorkout.putExtra(WORKOUT_ID, workout.id)
            startActivity(doWorkout)
        }

        val editClick = {
            workoutId : Int  ->
            val intent = Intent(this, CustomizeWorkout::class.java)
            intent.putExtra("workout_id", workoutId)
            startActivity(intent)
        }

        //Add Button
        addWorkoutBtn.setOnClickListener { view ->
            val createWorkout = Intent(this, CreateWorkout::class.java)
            startActivity(createWorkout)
        }

        workoutList.setHasFixedSize(true)
        workoutList.layoutManager = LinearLayoutManager(this)
        workoutList.adapter = WorkoutAdapter(this, workouts, workoutClicked, editClick)



    }
}
