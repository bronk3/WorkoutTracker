package com.bronk3.workouttracker.Model

import com.bronk3.workouttracker.Utility.*

object WorkoutCollection {
    var database = arrayListOf<Workout>(
            Workout("Abs", getDateNow(), arrayListOf(
                    ExersizeCollection.create(ExersizeId.CRUNCH)!!,
                    ExersizeCollection.create(ExersizeId.BENCHPRESS)!!,
                    ExersizeCollection.create(ExersizeId.VSIT)!!)
            ),
            Workout("Legs", getDateNow(), arrayListOf(
                    ExersizeCollection.create(ExersizeId.SQUAT)!!,
                    ExersizeCollection.create(ExersizeId.LUNGE)!!,
                    ExersizeCollection.create(ExersizeId.DIPS)!!)
            ),
            Workout("Arms", getDateNow(), arrayListOf(
                    ExersizeCollection.create(ExersizeId.BENCHPRESS)!!,
                    ExersizeCollection.create(ExersizeId.TRICEPDIP)!!,
                    ExersizeCollection.create(ExersizeId.PUSHUP)!!)
            )
    )
}