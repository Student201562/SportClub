package com.example.kiril.sportclubwithanko.DB

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.kiril.sportclubwithanko.Dao.TrainerDao
import com.example.kiril.sportclubwithanko.Data.TrainerInfo


@Database(entities = [TrainerInfo::class], version = 1)
abstract class CatalogDatabase : RoomDatabase() {

    abstract fun trainerDao() : TrainerDao
}