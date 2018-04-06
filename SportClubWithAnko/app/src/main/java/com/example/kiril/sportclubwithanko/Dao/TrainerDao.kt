package com.example.kiril.sportclubwithanko.Dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kiril.sportclubwithanko.Data.TrainerInfo


@Dao
interface TrainerDao {

    @Query("SELECT * FROM TrainerInfo")
    fun getAll(): List<TrainerInfo>

    @Insert
    fun insertAll(trainers: List<TrainerInfo>)
}