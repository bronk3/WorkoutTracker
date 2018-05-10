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
import com.bronk3.workouttracker.Model.WorkoutCollection.createWorkout
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Utility.*
import kotlinx.android.synthetic.main.activity_create_workout.*

class CreateWorkout : AppCompatActivity() {

    private lateinit var recyclerLayout: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    lateinit var selectedExersizeArrayList: ArrayList<Exersize>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)

        //
        val exersizeClick = { exersize: Exersize ->
            selectedExersizeArrayList.add(exersize)
        }

        CustomizeWorkoutBtn.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            var layout = layoutInflater.inflate(R.layout.workout_name_alert, null)
            builder.setView(layout)
                    .setPositiveButton("Ok") { _, _ ->
                        val workoutName = layout.findViewById<EditText>(R.id.dialogWorkoutName)
                        val newWorkout = createWorkout(workoutName.text.toString(), getDateNow())

                        val customizeWorkout = Intent(this, CustomizeWorkout::class.java)
                        customizeWorkout.putExtra(WORKOUT, newWorkout)
                        customizeWorkout.putExtra(EXERSIZE_LIST, selectedExersizeArrayList)
                        startActivity(customizeWorkout)
                    }
                    .setNegativeButton("Cancel") { _, _ ->
                    }.show()
        }

        // Show Exersizes
        chooseExersize.adapter = CreateWorkoutAdapter(this, ExersizeCollection.list(), exersizeClick)
        chooseExersize.layoutManager = GridLayoutManager(this, 3)
        chooseExersize.setHasFixedSize(true)

    }
}
