package com.example.kiril.sportclubwithanko.Data

import com.example.kiril.sportclubwithanko.TrainerInfo
import com.example.kiril.sportclubwithanko.App
import com.google.gson.Gson
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.experimental.CoroutineContext


fun loadingData(
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

fun loadingTrainerInfo(
        app: App,
        coroutineContext: CoroutineContext = CommonPool
): Deferred<List<TrainerInfo>> = async(coroutineContext) {
    app.database.trainerDao().getAll()
}
