package com.example.kiril.sportclubwithanko

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlin.coroutines.experimental.CoroutineContext



fun savePhotos(
        app: App,
        roducts: List<TrainerInfo>,
        coroutineContext: CoroutineContext = CommonPool
): Deferred<Unit> = async(coroutineContext) {
    app.database.trainerDao().insertAll(roducts)
}