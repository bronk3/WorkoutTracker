package com.bronk3.workouttracker.Model

object ExersizeCollection {

    fun indexOf(name: String): Int {
        for (exersize in list) {
            if (exersize.name == name)
                return list.indexOf(exersize)
        }
        return -1
    }

    fun find(name: String) : Exersize {
        for (exersize in list) {
            if (exersize.name == name)
                return exersize
        }
        return list[0]
    }

    fun at(index: Int): Exersize {
        return list[index]
    }

    private var list = arrayListOf(
             Exersize( "Crunch", "filter", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "v-situp", "filter_data", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Squats", "focus_group", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Lunges", "front_desk", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Tricep dips", "multimple_solutions", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Shoulder press", "oil", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Row", "plastic_bottle", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize("run", "positioning", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Box Jump", "service_waste_disposal", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Sprint", "solution", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "mountain climber", "solution2", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize("Lunges", "front_desk", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Tricep dips", "multimple_solutions", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Shoulder press", "oil", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "Row", "plastic_bottle", null, 8, 3, 10, MeasurementTypes.KG),
             Exersize( "deadlift", "trophy", null, 8, 3, 10, MeasurementTypes.KG)
    )

    fun list() : ArrayList<Exersize> {
        return list
    }

}