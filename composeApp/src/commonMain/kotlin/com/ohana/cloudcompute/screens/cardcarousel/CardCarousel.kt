package com.ohana.cloudcompute.screens.cardcarousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CardCarousel(congestionLevel: String, expectedWaitingPeople: String, expectedWaitingTime: String) {
    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp) // 상하 패딩 추가
            .fillMaxWidth() // 가로 너비를 채움
    ) {
        items(3) { index ->
            when (index) {
                0 -> CardItem(
                    title = "혼잡 등급",
                    content = {
                        Box {
                            Text(text = "혼잡도: $congestionLevel")
                        }
                    }
                )
                1 -> CardItem(
                    title = "예상 대기 인원",
                    content = {
                        Box {
                            Text(text = "예상 대기 인원: $expectedWaitingPeople 명")
                        }
                    }
                )
                2 -> CardItem(
                    title = "예상 대기 시간",
                    content = {
                        Box {
                            Text(text = "예상 대기 시간: $expectedWaitingTime 분")
                        }
                    }
                )
            }
        }
    }
}