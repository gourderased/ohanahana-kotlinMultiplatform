package com.ohana.cloudcompute.screens

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ohana.cloudcompute.LoadImage
import com.ohana.cloudcompute.data.CongestionObject
import com.ohana.cloudcompute.pretendardFontFamily
import com.ohana.cloudcompute.screens.cardcarousel.CardCarousel
import com.ohana.cloudcompute.screens.cardcarousel.CardItem
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_home_congestion
import kmp_app_template.composeapp.generated.resources.ic_bus_stop
import kmp_app_template.composeapp.generated.resources.ic_logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun SensorDataScreen(sensorData: CongestionObject) {
//    // Koin에서 ViewModel 가져오기
    val viewModel: SensorDataViewModel = koinViewModel()
    val sensorDataState = viewModel.sensorData.collectAsState() // 센서 데이터 상태를 수집

    val hazeState = remember { HazeState() }
    Box {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .haze(state = hazeState)
        ) {
            Image(
                painter = painterResource(Res.drawable.bg_home_congestion),
                contentDescription = "test",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 38.dp)
            ) {
                //상단 바
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(0.dp, 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LoadImage("ic_logo", "logo", Modifier.size(24.dp))

                    LoadImage("ic_refresh", "refresh", Modifier.size(24.dp))
                }

                Spacer(Modifier.height(12.dp))

                //주안역 방향 텍스트
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "주안역 방향",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = pretendardFontFamily
                        )
                    )
                }

                Spacer(Modifier.height(12.dp))

                //511 버스 대기줄의 현재 혼잡도 텍스트
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "511 버스 대기줄의\n현재 혼잡도",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = pretendardFontFamily
                        )
                    )
                }
            }
            //버스 정류장 이미지
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-60).dp)
                    .align(alignment = Alignment.Center),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_bus_stop),
                    contentDescription = "bus_stop",
                    modifier = Modifier
                        .size(242.dp)
                )
            }

        }
        //carousel
        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(y = 80.dp)
                .padding(horizontal = 24.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(3) { index ->
                    val cardSize = when (index) {
                        0 -> Modifier.size(width = 151.dp, height = 123.dp)
                        1 -> Modifier.size(width = 126.dp, height = 123.dp)
                        2 -> Modifier.size(width = 126.dp, height = 123.dp)
                        else -> Modifier.size(128.dp)
                    }
                    Box(
                        modifier = Modifier
                            .then(cardSize)
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color(0xffcdcdcd), shape = RoundedCornerShape(12.dp))
                            .hazeChild(state = hazeState) {
                                backgroundColor = Color.Blue
                                tints = listOf(HazeTint.Color(Color.White.copy(alpha = 0.1f)))
                                blurRadius = 8.dp
                                noiseFactor = HazeDefaults.noiseFactor
                            }
                            .align(Alignment.Center)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 12.dp)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {
                            when (index) {
                                0 -> {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,

                                        ) {
                                        LoadImage(
                                            "ic_logo_home_congestion",
                                            "content",
                                            Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "혼잡등급",
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        text = "혼잡",
                                        style = TextStyle(
                                            fontSize = 24.sp,
                                            color = Color(0xFF7A2CCD),
                                            fontWeight = FontWeight.SemiBold,
                                            fontFamily = pretendardFontFamily
                                        )
                                    )
                                    Spacer(Modifier.height(8.dp))

                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .background(Color.Transparent, shape = RoundedCornerShape(25.dp))
                                                .border(1.dp, Color(0xffdadada), shape = RoundedCornerShape(25.dp)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                                text = "여유",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    color = Color(0xFF666666),
                                                    fontWeight = FontWeight.Normal,
                                                    fontFamily = pretendardFontFamily
                                                )
                                            )
                                        }
                                        Divider(Modifier.width(8.dp), Color(0xFFD9D9D9))
                                        Box(
                                            modifier = Modifier
                                                .background(Color.Transparent, shape = RoundedCornerShape(25.dp))
                                                .border(1.dp, Color(0xffdadada), shape = RoundedCornerShape(25.dp)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                                text = "보통",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    color = Color(0xFF666666),
                                                    fontWeight = FontWeight.Normal,
                                                    fontFamily = pretendardFontFamily
                                                )
                                            )
                                        }
                                        Divider(Modifier.width(8.dp), Color(0xFFD9D9D9))
                                        Box(
                                            modifier = Modifier
                                                .background(Color(0xff793ACC).copy(alpha = 0.2f), shape = RoundedCornerShape(25.dp)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                                text = "혼잡",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    color = Color(0xFF1E0045),
                                                    fontWeight = FontWeight.Normal,
                                                    fontFamily = pretendardFontFamily
                                                )
                                            )
                                        }
                                    }
                                }

                                1 -> {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,

                                        ) {
                                        LoadImage(
                                            "ic_logo_home_congestion",
                                            "content",
                                            Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "예상 대기 인원",
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "20",
                                            style = TextStyle(
                                                fontSize = 24.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                        Text(
                                            text = "명",
                                            style = TextStyle(
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Medium,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        text = "예상 대기 인원은 실제와\n다를 수 있습니다.",
                                        style = TextStyle(
                                            fontSize = 10.sp,
                                            color = Color(0xFF666666),
                                            fontWeight = FontWeight.Medium,
                                            fontFamily = pretendardFontFamily
                                        )
                                    )
                                }

                                2 -> {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,

                                        ) {
                                        LoadImage(
                                            "ic_logo_home_congestion",
                                            "content",
                                            Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "예상 대기 시간",
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "25",
                                            style = TextStyle(
                                                fontSize = 24.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                        Text(
                                            text = "분",
                                            style = TextStyle(
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Medium,
                                                fontFamily = pretendardFontFamily
                                            )
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        text = "예상 대기 시간은 실제와\n다를 수 있습니다.",
                                        style = TextStyle(
                                            fontSize = 10.sp,
                                            color = Color(0xFF666666),
                                            fontWeight = FontWeight.Medium,
                                            fontFamily = pretendardFontFamily
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
