package com.bronk3.workouttracker.Model

object CustomizationCollection {

    private var customizationCollectionList = ArrayList<Customization>()

    fun createCustomizationList(exersizeList: ArrayList<Exersize>, workout: Workout) : ArrayList<Customization> {
        val customizationList = ArrayList<Customization>()
        for (exersize in exersizeList) {
            customizationList.add(create(exersize, workout))
        }
        return customizationList
    }

    fun updateCustomizationList(updatedCustomizationList: ArrayList<Customization>) : ArrayList<Customization> {
        //Find start index of this list

        // use the customizationCollectionList index from that point to update all of them
        return updatedCustomizationList
    }

    fun create(exersize: Exersize, workout: Workout): Customization {
        val customization = Customization(exersize, workout, null, null, null, null, null)
        customizationCollectionList.add(customization)
        return customization
    }

    fun create(exersize: Exersize, workout: Workout,
                            reps: Int, sets: Int): Customization {
        val customization = Customization(exersize, workout, null, reps, sets,null, null)
        customizationCollectionList.add(customization)
        return customization
    }

    fun create(exersize: Exersize, workout: Workout,
                            reps: Int, sets: Int, measure: Int, measureType: MeasurementTypes): Customization {
        val customization = Customization(exersize, workout, null, reps, sets, measure, measureType)
        customizationCollectionList.add(customization)
        return customization
    }
}