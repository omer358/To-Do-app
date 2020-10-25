package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    // if there's no completed tasks and one active task,
    // then there're 100% active tasks and then 0% completed tasks.

    @Test
    fun getActiveCompletedStats_noCompleted_returnsZeroHundred() {
        val tasks = listOf<Task>(
                Task("Testing in Android", "lkveovelrg", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
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