package com.bronk3.workouttracker.Controller

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do_workout)

        //Extras
        val workout_id = intent.getIntExtra(WORKOUT_ID, 0)
        val exersizeIdList = intent.getIntegerArrayListExtra(EXERSIZE_ID_LIST)

        if(workout_id != 0) {
            if (exersizeIdList == null) {
                // Edit Workout
                workout = getWorkoutById(workout_id)
                customizationList = getCustomizationByWorkoutId(workout_id)
            } else {
                //Create New Workout
                workout = getWorkoutById(workout_id)
                customizationList = createCustomizationListByExerciseIds(workout_id, exersizeIdList)
            }
        }


        val adapter = DoWorkoutAdapter(this, customizationList)
        setListContainer.layoutManager = LinearLayoutManager(this)
        setListContainer.adapter = adapter
        setListContainer.setHasFixedSize(true)

    }

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
