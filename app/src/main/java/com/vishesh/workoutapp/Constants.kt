package com.vishesh.workoutapp

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
         val exerciseList = ArrayList<ExerciseModel>()

        val jumpingJacks = ExerciseModel(
            1,
            "JUMPING JACKS",
            R.drawable.ic_jumping_jacks,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(
            2,
            "WALL SIT",
            R.drawable.ic_wall_sit,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(wallSit)

        val pushUp = ExerciseModel(
            3,
            "PUSH UP",
                R.drawable.ic_push_up,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(pushUp)

        val abdominalCrunch = ExerciseModel(
            4,
            "ABDOMINAL CRUNCH",
            R.drawable.ic_abdominal_crunch,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(abdominalCrunch)

        val tricepsDip = ExerciseModel(
            5,
            "TRICEPS DIP",
            R.drawable.ic_triceps_dip_on_chair,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(tricepsDip)

        val plank = ExerciseModel(
            6,
            "PLANK",
            R.drawable.ic_plank,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(plank)

        val stepUp = ExerciseModel(
            7,
            "STEP UP",
            R.drawable.ic_step_up_onto_chair,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(stepUp)

        val squat = ExerciseModel(
            8,
            "SQUAT",
            R.drawable.ic_squat,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(squat)

        val sidePlank = ExerciseModel(
            9,
            "SIDE PLANK",
            R.drawable.ic_side_plank,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(sidePlank)

        val pushUpRotate = ExerciseModel(
            10,
            "PUSH UP AND ROTATE",
            R.drawable.ic_push_up_and_rotation,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(pushUpRotate)

        val lunge = ExerciseModel(
            11,
            "LUNGE",
            R.drawable.ic_lunge,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(lunge)

        val highKnees = ExerciseModel(
            12,
            "HIGH KNEES",
            R.drawable.ic_high_knees_running_in_place,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(highKnees)

        return exerciseList
    }
}