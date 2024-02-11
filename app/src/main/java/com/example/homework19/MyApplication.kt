package com.example.homework19

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {
    lateinit var repo: TodoRepository
    override fun onCreate() {
        super.onCreate()
        instance = this
        val db = Room.databaseBuilder(this, TodoDatabase::class.java, "todo_database").build()
        repo = TodoRepository(db)
    }
    companion object {
        private lateinit var instance: MyApplication
        fun getApp() = instance
    }
}