package com.jetbrains.kmpapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetbrains.kmpapp.data.CongestionApi
import com.jetbrains.kmpapp.data.CongestionObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SensorDataViewModel(private val congestionApi: CongestionApi) : ViewModel() {
    private val _sensorData = MutableStateFlow<CongestionObject?>(null)
    val sensorData: StateFlow<CongestionObject?> = _sensorData

    init {
        fetchSensorData()
    }

    private fun fetchSensorData() {
        viewModelScope.launch {
            _sensorData.value = congestionApi.getData() // API에서 데이터 가져오기
        }
    }
}