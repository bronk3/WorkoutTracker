package com.bronk3.workouttracker.Model

class Exersize(val id: Int, val name: String, val image: String) {
    override fun toString(): String {
        return "Id: $id,\t Name: $name,\t Image: $image"
    }
}