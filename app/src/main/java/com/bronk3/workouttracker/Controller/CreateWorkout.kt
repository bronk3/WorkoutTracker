package com.bronk3.workouttracker.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.bronk3.workouttracker.R

class CreateWorkout : AppCompatActivity() {

    private lateinit var recyclerLayout: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)

//        chooseExersize.apply {
//            setHasFixedSize(true)
//            layoutManager = recyclerLayout
//            adapter = recyclerAdapter
//        }

    }
}
