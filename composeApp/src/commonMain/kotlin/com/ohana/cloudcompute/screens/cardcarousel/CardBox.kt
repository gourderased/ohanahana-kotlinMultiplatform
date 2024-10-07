//package com.ohana.cloudcompute.screens
//
//import androidx.compose.foundation.gestures.Orientation
//import androidx.compose.foundation.gestures.draggable
//import androidx.compose.foundation.gestures.rememberDraggableState
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableFloatStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import dev.chrisbanes.haze.HazeDefaults
//import dev.chrisbanes.haze.HazeState
//import dev.chrisbanes.haze.HazeTint
//import dev.chrisbanes.haze.hazeChild
//import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
//
//@OptIn(ExperimentalHazeMaterialsApi::class)
//@Composable
//fun CardBox(hazeState: HazeState) {
//    // 카드의 오프셋 값을 저장하는 상태를 생성합니다.
//    val cardOffset = remember { mutableFloatStateOf(0f) }
//    // 드래그 가능한 상태를 생성하여 드래그 이벤트를 처리합니다.
//    val draggableState = rememberDraggableState { delta ->
//        cardOffset.value += delta
//    }
//
//    // 드래그 가능한 카드 Box
//    Box(
//        modifier = Modifier
//            .testTag("credit_card") // 테스트를 위한 태그
//            .size(width = 151.dp, height = 123.dp)
//            .offset { IntOffset(x = 0, y = cardOffset.value.toInt()) }
//            // 드래그 가능하도록 설정
//            .draggable(
//                state = draggableState,
//                orientation = Orientation.Vertical, // 수직 방향으로 드래그
//            )
//            // 모서리를 둥글게 자름
//            .clip(RoundedCornerShape(12.dp))
//            .hazeChild(state = hazeState) {
//                backgroundColor = Color.White
//                tints = listOf(
//                    HazeTint.Color(
//                        Color.White.copy(alpha = 0.1f)
//                    )
//                ) // 틴트 색상 설정
//                blurRadius = 8.dp // 블러 반경 설정
//                noiseFactor = HazeDefaults.noiseFactor // 노이즈 설정
//            },
//    ) {
//        // 카드 내부의 콘텐츠
//        Column(Modifier.padding(32.dp)) {
//            Text("Bank of Haze") // 카드에 표시될 텍스트
//        }
//    }
//}