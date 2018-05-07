package com.bronk3.workouttracker.Model

class User(val id: Int, val name: String, val email: String, val weight: Int,
           val weightType: String, val height: Int, val heightType: String,
           val picture: String, val goal: Int,
           val workouts: ArrayList<Workout>)