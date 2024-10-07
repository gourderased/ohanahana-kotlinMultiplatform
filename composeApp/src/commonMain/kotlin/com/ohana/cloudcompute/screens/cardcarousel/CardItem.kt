package com.ohana.cloudcompute.screens.cardcarousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun CardItem(title: String, content: @Composable () -> Unit) {
    // 카드의 오프셋 값을 저장하는 상태를 생성합니다.
    val cardOffset = remember { mutableFloatStateOf(0f) }

    // 드래그 가능한 카드 Box
    Box(
        modifier = Modifier
            .size(width = 151.dp, height = 123.dp) // 카드 크기 고정
            .clip(RoundedCornerShape(12.dp))
            .hazeChild(state = HazeState()) { // Haze 효과 적용
                backgroundColor = Color.Blue // 배경색 설정
                tints = listOf(
                    HazeTint.Color(
                        Color.White.copy(alpha = 0.1f)
                    )
                ) // 틴트 색상 설정
                blurRadius = 8.dp // 블러 반경 설정
                noiseFactor = HazeDefaults.noiseFactor // 노이즈 설정
            }
            .offset { IntOffset(x = 0, y = cardOffset.value.toInt()) } // 오프셋 적용
    ) {
        // 카드 내부의 콘텐츠
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title) // 카드 제목
            content() // Box로 전달된 콘텐츠를 호출
        }
    }
}