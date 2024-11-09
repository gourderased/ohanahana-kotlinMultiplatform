package com.ohanahana.cloudcompute.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class BusRepository(private val busApi: BusApi) {
    private val scope = CoroutineScope(SupervisorJob())
    private val busData = MutableStateFlow<BusData?>(null)

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        val data = busApi.getBusData()
        busData.value = data
    }

    fun getBusDataFlow(): Flow<BusData?> = busData
}