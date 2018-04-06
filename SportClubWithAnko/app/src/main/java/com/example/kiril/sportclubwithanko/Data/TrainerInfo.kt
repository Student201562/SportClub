package com.example.kiril.sportclubwithanko.Data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
data class TrainerInfo(
        @PrimaryKey
        val id_trainer: String,
        val full_name: String,
        val telephone: String) { class List : ArrayList<TrainerInfo>() }