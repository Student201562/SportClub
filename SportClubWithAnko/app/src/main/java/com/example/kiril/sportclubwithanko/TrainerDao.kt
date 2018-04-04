package com.example.kiril.sportclubwithanko

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface TrainerDao {

    @Query("SELECT * FROM TrainerInfo")
    fun getAll(): List<TrainerInfo>

    @Insert
    fun insertAll(trainers: List<TrainerInfo>)
}