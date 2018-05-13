package com.bronk3.workouttracker.Model

import com.bronk3.workouttracker.Utility.getDateNow

object ExersizeCollection {

    var database = arrayOf(
            Exersize(ExersizeId.BENCHPRESS, "plastic_bottle", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.CRUNCH, "service_waste_disposal", 8, 3, 15, MeasurementTypes.NA),
            Exersize(ExersizeId.DIPS, "solution", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.LUNGE, "solution2", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.PUSHUP, "stats_histogram", 8, 3, 15, MeasurementTypes.NA),
            Exersize(ExersizeId.SQUAT, "stats_pie_chart", 8, 3, 15, MeasurementTypes.KG),
            Exersize(ExersizeId.TRICEPDIP, "stock_market", 8, 3, 15, MeasurementTypes.NA),
            Exersize(ExersizeId.VSIT, "task", 8, 3, 15, MeasurementTypes.NA)
    )
    var CustomDatabase = ArrayList<Exersize>()
    var HistoryDatabase = ArrayList<Exersize>()

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
            CustomDatabase.add(newExersize)
            newExersize.Id = CustomDatabase.count()
            return newExersize
        }
        return null
    }

    fun saveToHistory(exersize: Exersize) {
        val save = copy(exersize)
        save.complete = 1
        save.finishTime = getDateNow()
        HistoryDatabase.add(save)
        exersize.reset()
    }

    fun create(id: ExersizeId): Exersize? {
        val baseExersize = ExersizeCollection.find(id)
        if(baseExersize != null) {
            CustomDatabase.add(baseExersize)
            baseExersize.Id = CustomDatabase.count() - 1
            return baseExersize
        }
        return null
    }

    fun copy(exersize: Exersize): Exersize {
        var copy = Exersize(
                exersize.name,
                exersize.image,
                exersize.reps,
                exersize.sets,
                exersize.measure,
                exersize.measureType
        )
        copy.Id = exersize.Id
        return copy
    }

    fun find(id: ExersizeId): Exersize? {
       for(exersize in database) {
           if(exersize.name == id)
               return exersize
       }
        return null
    }

    fun find(id: Int): Exersize? {
        if(id <= CustomDatabase.count()) {
            return CustomDatabase[id]
        }
        return null
    }
}