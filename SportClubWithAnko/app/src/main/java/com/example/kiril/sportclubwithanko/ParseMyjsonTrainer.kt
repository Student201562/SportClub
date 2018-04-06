package com.example.kiril.sportclubwithanko

import com.example.kiril.sportclubwithanko.DB.App
import com.example.kiril.sportclubwithanko.Data.CompanyInfo
import com.example.kiril.sportclubwithanko.Data.DiscountInfo
import com.example.kiril.sportclubwithanko.Data.TrainerInfo
import com.google.gson.Gson
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.experimental.CoroutineContext


fun loadingDataTrainerInfo(
        coroutineContext: CoroutineContext = CommonPool
): Deferred<List<TrainerInfo>> = async(coroutineContext) {
    // Создать клиент для HTTP запросов
    val httpClient = OkHttpClient()

    // Создать запрос
    val request = Request.Builder()
            .url("https://api.myjson.com/bins/wykkz")
            .build()

    httpClient.newCall(request).execute().use {
        Gson().fromJson(it.body()!!.string(), TrainerInfo.List::class.java)
    }
}

fun loadingDataDiscountInfo(
        coroutineContext: CoroutineContext = CommonPool
): Deferred<List<DiscountInfo>> = async(coroutineContext) {
    // Создать клиент для HTTP запросов
    val httpClient = OkHttpClient()

    // Создать запрос
    val request = Request.Builder()
            .url("https://api.myjson.com/bins/ve2mr")
            .build()

    httpClient.newCall(request).execute().use {
        Gson().fromJson(it.body()!!.string(), DiscountInfo.List::class.java)
    }
}

fun loadingDataCompanyInfo(
        coroutineContext: CoroutineContext = CommonPool
): Deferred<List<CompanyInfo>> = async(coroutineContext) {
    // Создать клиент для HTTP запросов
    val httpClient = OkHttpClient()

    // Создать запрос
    val request = Request.Builder()
            .url("https://api.myjson.com/bins/19l9er")
            .build()

    httpClient.newCall(request).execute().use {
        Gson().fromJson(it.body()!!.string(), CompanyInfo.List::class.java)
    }
}

fun loadingTrainerInfo(
        app: App,
        coroutineContext: CoroutineContext = CommonPool
): Deferred<List<TrainerInfo>> = async(coroutineContext) {
    app.database.trainerDao().getAll()
}
