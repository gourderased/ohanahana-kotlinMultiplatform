package com.ohana.cloudcompute.data

interface BusApi {
    suspend fun getBusData(): BusData
}