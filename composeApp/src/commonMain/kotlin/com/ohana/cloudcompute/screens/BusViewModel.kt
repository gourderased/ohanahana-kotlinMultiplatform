package com.ohana.cloudcompute.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohana.cloudcompute.data.BusApi
import com.ohana.cloudcompute.data.BusData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BusViewModel(private val busApi: BusApi) : ViewModel() {
    private val _busData = MutableStateFlow<BusData?>(null)
    val busData: StateFlow<BusData?> = _busData

    init {
        fetchBusData()
    }


    fun fetchBusData() {
        viewModelScope.launch {
            LoadingState.show()
            try {
                val data = busApi.getBusData()
                _busData.value = data

                delay(2000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                LoadingState.hide() // 로딩 상태 숨기기
            }
        }
    }
}