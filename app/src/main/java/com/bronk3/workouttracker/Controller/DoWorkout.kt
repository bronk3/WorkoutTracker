package com.bronk3.workouttracker.Controller

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Adapter.DoWorkoutAdapter
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Utility.*
import kotlinx.android.synthetic.main.activity_do_workout.*


class DoWorkout : AppCompatActivity() {

    lateinit var workout: Workout
    var customizationList = ArrayList<Customization>()

// TODO: Save workout state
//    override fun onSaveInstanceState(savedInstanceState: Bundle?) {
//        super.onSaveInstanceState(savedInstanceState)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        super.onRestoreInstanceState(savedInstanceState)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do_workout)

        //Extras
        val workout_id = intent.getIntExtra(WORKOUT, 0)
        val exersizeIdList = intent.getIntegerArrayListExtra(EXERSIZE_LIST)


        val adapter = DoWorkoutAdapter(this, customizationList)
        setListContainer.layoutManager = LinearLayoutManager(this)
        setListContainer.adapter = adapter
        setListContainer.setHasFixedSize(true)

        // TODO Record when workout is complete

    }

// TODO either warn when leaving workout or ask to resume left workout
//    override fun onBackPressed() {
////        var endWorkoutWarning = AlertDialog.Builder(this)
////        endWorkoutWarning
////                .setTitle("Done your Workout?")
////                .setPositiveButton("Cha", { _, _ ->
////                    finish()
////                })
////                .setNegativeButton("Nah", { _, _ ->
////
////                }).show()
//    }
}
