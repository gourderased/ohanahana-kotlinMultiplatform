package com.ohana.cloudcompute.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohana.cloudcompute.data.CongestionApi
import com.ohana.cloudcompute.data.CongestionObject
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_home_congestion
import kmp_app_template.composeapp.generated.resources.bg_home_normal
import kmp_app_template.composeapp.generated.resources.bg_home_white
import kmp_app_template.composeapp.generated.resources.ic_bus_stop
import kmp_app_template.composeapp.generated.resources.ic_error
import kmp_app_template.composeapp.generated.resources.ic_heart
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource

data class SensorDataUiState(
    val congestionLevelText: String = "",
    val expectedWaitingTime: String = "",
    val expectedWaitingPeople: String = "",
    val backgroundImage: DrawableResource = Res.drawable.bg_home_normal,
    val iconResource: DrawableResource = Res.drawable.ic_bus_stop,
    val headerText: String = "",
    val isSensorActive: Boolean = true,
    val isValidCongestion: Boolean = true
)

class SensorDataViewModel(private val congestionApi: CongestionApi) : ViewModel() {
    private val _uiState = MutableStateFlow(SensorDataUiState())
    val uiState: StateFlow<SensorDataUiState> = _uiState.asStateFlow()

    init {
        fetchSensorData()
    }

    fun fetchSensorData() {
        viewModelScope.launch {
            LoadingState.show()
            try {
                val data = congestionApi.getData()
                val uiState = processSensorData(data)

                _uiState.value = uiState

                delay(2000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                LoadingState.hide()
            }
        }
    }

    private fun processSensorData(data: CongestionObject): SensorDataUiState {
        val congestion = "SENSOR_ERROR"
        val congestionLevelText = getCongestionLevelText("SENSOR_ERROR")
        val backgroundImage = getBackgroundImage("SENSOR_ERROR")
        val iconResource = getIconResource("SENSOR_ERROR")

        // 혼잡도 유효성 확인
        val isValidCongestion = isValidCongestion(congestion)

        val (waitingTime, waitingPeople) = when (congestion) {
            "SENSOR_INACTIVE" -> "-" to "-"
            "SENSOR_ERROR" -> "오류 발생" to "오류 발생"
            else -> data.expectedWaitingTime to data.expectedWaitingPeople
        }

        // 헤더 텍스트 설정
        val headerText = when (congestion) {
            "SENSOR_INACTIVE" -> "현재는 센서 미작동\n시간이에요"
            "SENSOR_ERROR" -> "현재 센서에 문제가\n발생했어요"
            else -> "511 버스 대기줄의\n현재 혼잡도"
        }

        val showDirectionText = congestion != "SENSOR_INACTIVE"

        return SensorDataUiState(
            congestionLevelText = congestionLevelText,
            expectedWaitingTime = waitingTime,
            expectedWaitingPeople = waitingPeople,
            backgroundImage = backgroundImage,
            iconResource = iconResource,
            headerText = headerText,
            isSensorActive = showDirectionText,
            isValidCongestion = isValidCongestion
        )
    }

    private fun getCongestionLevelText(congestion: String): String {
        return when (congestion) {
            "SPARE" -> "여유"
            "NORMAL" -> "보통"
            "CONGESTION" -> "혼잡"
            "SENSOR_INACTIVE" -> "-"
            else -> "오류 발생"
        }
    }

    private fun getBackgroundImage(congestion: String): DrawableResource {
        return when (congestion) {
            "SPARE" -> Res.drawable.bg_home_white
            "NORMAL" -> Res.drawable.bg_home_normal
            "CONGESTION" -> Res.drawable.bg_home_congestion
            "SENSOR_INACTIVE" -> Res.drawable.bg_home_white
            else -> Res.drawable.bg_home_white
        }
    }

    private fun getIconResource(congestion: String): DrawableResource {
        return when (congestion) {
            "SPARE" -> Res.drawable.ic_bus_stop
            "NORMAL" -> Res.drawable.ic_bus_stop
            "CONGESTION" -> Res.drawable.ic_bus_stop
            "SENSOR_INACTIVE" -> Res.drawable.ic_heart
            else -> Res.drawable.ic_error
        }
    }

    private fun isValidCongestion(congestion: String): Boolean {
        return congestion == "SPARE" || congestion == "NORMAL" || congestion == "CONGESTION"
    }
}