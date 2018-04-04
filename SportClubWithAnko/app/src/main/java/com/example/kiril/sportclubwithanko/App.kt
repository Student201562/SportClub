package com.example.kiril.sportclubwithanko

import android.app.Application
import android.arch.persistence.room.Room

class App : Application() {

    lateinit var database: CatalogDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, CatalogDatabase::class.java, "catalog").build()
    }
}