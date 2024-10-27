package com.ohana.cloudcompute.data

import kotlinx.serialization.Serializable

@Serializable
data class BusStop(
    val busStopName: String,
    val busStopNumber: String?,
    val busNumber: String,
    val remainTime: Int,
    val remainBusStop: Int,
    val congestion: Int,
    val des: String,
    val estimatedTime: Int,
    val isTransfer: Boolean
)

@Serializable
data class BusData(
    val shuttle: BusStop,
    val ddg: BusStop,
    val yg: BusStop,
    val inhaFrontGate: BusStop
)