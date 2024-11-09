package com.ohanahana.cloudcompute.data

interface BusApi {
    suspend fun getBusData(): BusData
}