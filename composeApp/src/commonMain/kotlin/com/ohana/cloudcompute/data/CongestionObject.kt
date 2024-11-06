package com.ohana.cloudcompute.data

import kotlinx.serialization.Serializable

@Serializable
data class CongestionObject(
    val currentLocation: String,
    val currentDateTime: String,
    val congestion: String,
    val expectedWaitingTime: Int,
    val expectedWaitingPeople: String
)