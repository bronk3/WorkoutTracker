package com.bronk3.workouttracker.Controller

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import com.bronk3.workouttracker.Adapter.CreateWorkoutAdapter
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.ExersizeCollection
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Model.WorkoutCollection
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.*
import kotlinx.android.synthetic.main.activity_create_workout.*

class CreateWorkout : AppCompatActivity() {

    lateinit var adapter: CreateWorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)


        CustomizeWorkoutBtn.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            var layout = layoutInflater.inflate(R.layout.workout_name_alert, null)
            builder.setView(layout)
                    .setPositiveButton("Ok") { _, _ ->
                        val workoutName = layout.findViewById<EditText>(R.id.dialogWorkoutName)
                        val selectedExersizeArrayList = getSelected(adapter.returnSelectedExersizeArray())
                        val newWorkout =
                                WorkoutCollection.create(workoutName.text.toString(), getDateNow(), selectedExersizeArrayList)
                        val customizeWorkout = Intent(this, CustomizeWorkout::class.java)
                        customizeWorkout.putExtra(WORKOUT, newWorkout)
                        customizeWorkout.putExtra(WORKOUT_ID, newWorkout.Id)
                        startActivity(customizeWorkout)
                    }
                    .setNegativeButton("Cancel") { _, _ ->
                    }.show()
        }

        // Show Exersizes
        adapter = CreateWorkoutAdapter(this, ExersizeCollection.database)
        chooseExersize.adapter = adapter
        chooseExersize.layoutManager = GridLayoutManager(this, 3)
        chooseExersize.setHasFixedSize(true)
    }

    fun getSelected(selectedBooleanArray: BooleanArray) : ArrayList<Exersize> {
        val selected = ArrayList<Exersize>()
        for((index, value) in selectedBooleanArray.withIndex()) {
            if(value)
                selected.add(ExersizeCollection.database[index])
        }
        return selected
    }
}
