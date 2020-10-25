package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * There're 3 strategies that can makes your Test more readable:
 * 1- Naming: giving.
 * 2- Structure your code using (GIVING/WHEN/THEN) or
 * (Arrange/Act/Assert).
 * 3- Use Assertion frameworks
 * */

class StatisticsUtilsTest {

    /**
     * In programming, there are many convention that you should follow,
     * here I'm using:
     * SubjectUnderTest_actionOrInput_resultState()
     * if there's no completed tasks and one active task,
     * then there're 100% active tasks and then 0% completed tasks.
     */


    @Test
    fun getActiveCompletedStats_noCompleted_returnsZeroHundred() {

        // (GIVEN), given a list of tasks with a single, active task.
        val tasks = listOf<Task>(
                Task("Testing in Android", "lkveovelrg", isCompleted = false)
        )

        // (WHEN), when you call getActiveAndCompletedStats()
        val result = getActiveAndCompletedStats(tasks)

        // (THEN), then, there're 0% completed tasks and 100% active tasks.
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    // if there're two completed tasks and three active tasks,
    // then there're 40% completed tasks and 60% active tasks.

    @Test
    fun getActiveAndCompletedStats_both_returnFortySixty() {
        val tasks = listOf<Task>(
                Task(title = "dfkdkfllkf", description = "dlfkgpqfvgjfr", isCompleted = true),
                Task(title = "dfkdkfllkf", description = "dlfkgpqfvgjfr", isCompleted = true),
                Task(title = "dfkdkfllkf", description = "dlfkgpqfvgjfr", isCompleted = false),
                Task(title = "dfkdkfllkf", description = "dlfkgpqfvgjfr", isCompleted = false),
                Task(title = "dfkdkfllkf", description = "dlfkgpqfvgjfr", isCompleted = false)
        )

        val results = getActiveAndCompletedStats(tasks)

        assertEquals(40f, results.completedTasksPercent)
        assertEquals(60f, results.activeTasksPercent)
    }

    @Test
    fun getActiveCompletedStats_empty_returnsZeroHundred() {

        // (Given)
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveCompletedStats_error_returnsZeroHundred() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}