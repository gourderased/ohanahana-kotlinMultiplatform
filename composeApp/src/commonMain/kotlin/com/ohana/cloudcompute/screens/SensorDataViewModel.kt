package com.ohana.cloudcompute.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohana.cloudcompute.data.CongestionApi
import com.ohana.cloudcompute.data.CongestionObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SensorDataViewModel(private val congestionApi: CongestionApi) : ViewModel() {
    private val _sensorData = MutableStateFlow<CongestionObject?>(null)
    val sensorData: StateFlow<CongestionObject?> = _sensorData

    init {
        fetchSensorData()
    }

    fun fetchSensorData() {
        viewModelScope.launch {
            LoadingState.show()
            try {
                val data = congestionApi.getData()
                _sensorData.value = data

                delay(2000)
            } catch (e: Exception) {

                e.printStackTrace()
            } finally {
                LoadingState.hide()
            }
        }
    }
}