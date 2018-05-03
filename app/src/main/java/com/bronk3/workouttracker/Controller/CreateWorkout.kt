package com.bronk3.workouttracker.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.bronk3.workouttracker.Adapter.CreateWorkoutAdapter
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.R
import com.bronk3.workouttracker.Services.DataSet
import com.bronk3.workouttracker.Utility.EXERSIZE_ID_LIST
import com.bronk3.workouttracker.Utility.WORKOUT_ID
import com.bronk3.workouttracker.Utility.createWorkout
import com.bronk3.workouttracker.Utility.getDate
import kotlinx.android.synthetic.main.activity_create_workout.*

class CreateWorkout : AppCompatActivity() {

    private lateinit var recyclerLayout: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    lateinit var selectedIds: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)

        val exersizeClick = { exersize: Exersize, selectedIdHash: HashMap<Int, Int> ->
            exersizeCount.text = selectedIdHash.count().toString()
            selectedIds = ArrayList(selectedIdHash.values)
        }

        chooseExersize.adapter = CreateWorkoutAdapter(this, DataSet.exersizes, exersizeClick)
        chooseExersize.layoutManager = GridLayoutManager(this, 3)
        chooseExersize.setHasFixedSize(true)

        CustomizeWorkoutBtn.setOnClickListener {
            val customizeWorkout = Intent(this, CustomizeWorkout::class.java)
            val workoutId = createWorkout(workoutName.text.toString(), getDate())
            customizeWorkout.putExtra(WORKOUT_ID, workoutId)
            customizeWorkout.putExtra(EXERSIZE_ID_LIST, selectedIds)
            startActivity(customizeWorkout)
        }
    }
}
