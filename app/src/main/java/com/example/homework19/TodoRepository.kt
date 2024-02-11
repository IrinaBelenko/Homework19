package com.example.homework19

import java.util.concurrent.Executors

class TodoRepository(private val database: TodoDatabase) {
    private val executor = Executors.newSingleThreadExecutor()

    fun getAll() = database.todoDao().getAll()

    fun add(todo: Todo) {
        executor.execute { database.todoDao().add(todo) }
    }

    fun remove(todo: Todo) {
        executor.execute { database.todoDao().delete(todo) }
    }
}