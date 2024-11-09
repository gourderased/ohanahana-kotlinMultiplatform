package com.ohanahana.cloudcompute.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlin.coroutines.cancellation.CancellationException

class KtorBusApi(private val client: HttpClient) : BusApi {
    companion object {
        private const val API_URL = "http://ohhanahana.kro.kr:8080/bus" // 버스 정보 API의 URL
    }

    override suspend fun getBusData(): BusData {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()
            BusData(
                BusStop("", "", "", 0, 0, 0, "", 0, false),
                BusStop("", "", "", 0, 0, 0, "", 0, false),
                BusStop("", "", "", 0, 0, 0, "", 0, false),
                BusStop("", "", "", 0, 0, 0, "", 0, false)
            )
        }
    }
}