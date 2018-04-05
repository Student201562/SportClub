package com.example.kiril.sportclubwithanko

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = [TrainerInfo::class], version = 1)
abstract class CatalogDatabase : RoomDatabase() {

    abstract fun trainerDao() : TrainerDao
}