package com.bronk3.workouttracker.Model

object ExersizeCollection {

    var database = arrayOf(
            Exersize(ExersizeId.BENCHPRESS, "", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.CRUNCH, "", 8, 3, 15, MeasurementTypes.NA),
            Exersize(ExersizeId.DIPS, "", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.LUNGE, "", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.PUSHUP, "", 8, 3, 15, MeasurementTypes.NA),
            Exersize(ExersizeId.SQUAT, "", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.TRICEPDIP, "", 8, 3, 15, MeasurementTypes.NA),
            Exersize(ExersizeId.VSIT, "", 8, 3, 15, MeasurementTypes.NA)
    )
    var CustomDatabase = ArrayList<Exersize>()

    fun create(id: ExersizeId, reps: Int?, sets: Int?, measure: Int?, measurementTypes: MeasurementTypes?): Exersize? {
        val baseExersize = ExersizeCollection.find(id)
        if(baseExersize != null) {
            val newExersize = Exersize(
                    baseExersize.name,
                    baseExersize.image,
                    reps ?: baseExersize.reps,
                    sets ?: baseExersize.sets,
                    measure ?: baseExersize.measure,
                    measurementTypes ?: baseExersize.measureType
            )
            return newExersize
        }
        return null
    }

    fun create(id: ExersizeId): Exersize? {
        val baseExersize = ExersizeCollection.find(id)
        if(baseExersize != null) {
            return baseExersize
        }
        return null
    }

    fun find(id: ExersizeId): Exersize? {
       for(exersize in database) {
           if(exersize.name == id)
               return exersize
       }
        return null
    }
}