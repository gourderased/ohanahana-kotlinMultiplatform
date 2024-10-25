package com.ohana.cloudcompute.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.ohana.cloudcompute.LoadImage
import com.ohana.cloudcompute.data.CongestionObject
import com.ohana.cloudcompute.pretendardFontFamily
import io.github.kubode.compose.boxshadow.boxShadow
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_home_congestion
import kmp_app_template.composeapp.generated.resources.ic_bus_stop
import kmp_app_template.composeapp.generated.resources.ic_magnify
import kmp_app_template.composeapp.generated.resources.ic_notice
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SensorDataScreen(sensorData: CongestionObject, navController: NavController) {
//    Koin에서 ViewModel 가져오기
    val viewModel: SensorDataViewModel = koinViewModel()
    val sensorDataState = viewModel.sensorData.collectAsState() // 센서 데이터 상태를 수집

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 가이드라인 생성
        val guidelineTop06 = createGuidelineFromTop(0.06f)
        val guidelineTop13 = createGuidelineFromTop(0.13f)
        val guidelineTop14 = createGuidelineFromTop(0.14f)
        val guidelineTop17 = createGuidelineFromTop(0.17f)
        val guidelineTop18 = createGuidelineFromTop(0.18f)
        val guidelineTop23 = createGuidelineFromTop(0.23f)
        val guidelineTop27 = createGuidelineFromTop(0.27f)
        val guidelineTop56 = createGuidelineFromTop(0.56f)
        val guidelineTop61 = createGuidelineFromTop(0.61f)
        val guidelineTop72 = createGuidelineFromTop(0.72f)
        val guidelineTop74 = createGuidelineFromTop(0.74f)
        val guidelineTop91 = createGuidelineFromTop(0.91f)
        val guidelineTop92 = createGuidelineFromTop(0.92f)
        val guidelineTop98 = createGuidelineFromTop(0.98f)


        val textJuan = createRef()

        // 배경 이미지
        Image(
            painter = painterResource(Res.drawable.bg_home_congestion),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 상단 바
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop06)
                    bottom.linkTo(guidelineTop13)
                }
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LoadImage("ic_logo", "logo", Modifier.size(24.dp))
            LoadImage("ic_refresh", "refresh", Modifier.size(24.dp))
        }

        // 주안역 방향 텍스트
        Text(
            text = "주안역 방향",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = pretendardFontFamily
            ),
            modifier = Modifier.padding(horizontal = 24.dp)
                .fillMaxWidth()
                .constrainAs(textJuan) {
                    top.linkTo(guidelineTop14)
                    bottom.linkTo(guidelineTop17)
                }
        )

        // 511 버스 대기줄의 현재 혼잡도 텍스트
        Text(
            text = "511 버스 대기줄의\n현재 혼잡도",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = pretendardFontFamily
            ),
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop18)
                    bottom.linkTo(guidelineTop23)
                }
        )

        // 버스 정류장 이미지
        Image(
            painter = painterResource(Res.drawable.ic_bus_stop),
            contentDescription = "bus_stop",
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()

                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop27)
                    bottom.linkTo(guidelineTop61)
                }
        )

        // carousel
        Box(
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop56)
                    bottom.linkTo(guidelineTop72)
                }
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(5) { index ->
                    val cardSize = when (index) {
                        0, 4 -> Modifier.size(width = 16.dp, height = 123.dp)
                        1 -> Modifier.size(width = 151.dp, height = 123.dp)
                        2 -> Modifier.size(width = 126.dp, height = 123.dp)
                        3 -> Modifier.size(width = 126.dp, height = 123.dp)
                        else -> Modifier.size(128.dp)
                    }

                    // 0과 4인 경우
                    if (index == 0 || index == 4) {
                        Box(
                            modifier = Modifier
                                .then(cardSize)
                        )
                    } else { // 1, 2, 3인 경우
                        Box(
                            modifier = Modifier
                                .border(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xffF1F1F1),
                                            Color(0xffEBEBEB),
                                        )
                                    ),
                                    width = 1.dp,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .then(cardSize)
                                .boxShadow(
                                    color = Color.Black.copy(alpha = 0.2f),
                                    offset = DpOffset(0.dp, 4.dp),
                                    radius = 8.dp,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .background(
                                    brush = Brush.linearGradient(
                                        colorStops = arrayOf(
                                            0.0f to Color(0xffFFFFFF).copy(alpha = 0.3f),
                                            0.62f to Color(0xffF2F2F2).copy(alpha = 0.3f),
                                            0.88f to Color(0xffE9E9E9).copy(alpha = 0.3f),
                                            1f to Color(0xffF1F1F1).copy(alpha = 0.3f),
                                        ),
                                        start = Offset.Zero,
                                        end = Offset.Infinite
                                    )
                                )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 16.dp, horizontal = 12.dp)
                                    .fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                when (index) {
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
                                                    .background(
                                                        Color.Transparent,
                                                        shape = RoundedCornerShape(25.dp)
                                                    )
                                                    .border(
                                                        1.dp,
                                                        Color(0xffF1F1F1),
                                                        shape = RoundedCornerShape(25.dp)
                                                    ),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(
                                                        horizontal = 8.dp,
                                                        vertical = 4.dp
                                                    ),
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
                                                    .background(
                                                        Color.Transparent,
                                                        shape = RoundedCornerShape(25.dp)
                                                    )
                                                    .border(
                                                        1.dp,
                                                        Color(0xffF1F1F1),
                                                        shape = RoundedCornerShape(25.dp)
                                                    ),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(
                                                        horizontal = 8.dp,
                                                        vertical = 4.dp
                                                    ),
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
                                                    .background(
                                                        Color(0xff793ACC).copy(alpha = 0.2f),
                                                        shape = RoundedCornerShape(25.dp)
                                                    ),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(
                                                        horizontal = 8.dp,
                                                        vertical = 4.dp
                                                    ),
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
                                            Spacer(Modifier.width(4.dp))
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

                                    3 -> {
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
                                            Spacer(Modifier.width(4.dp))
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

        //프로젝트 소개 박스
        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .boxShadow(
                    color = Color(0xff793ACC).copy(alpha = 0.1f),
                    offset = DpOffset(0.dp, 2.dp),
                    radius = 1.dp,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color(0xffFAFAFA))
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop74)
                    bottom.linkTo(guidelineTop91)
                }
                .fillMaxWidth()
                .clickable { navController.navigate("projectInfo") }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 20.dp, start = 20.dp, end = 11.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(Modifier.height(8.dp))
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "오하나하나",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = pretendardFontFamily
                            )
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "프로젝트 소개",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = pretendardFontFamily
                            )
                        )
                        Spacer(Modifier.height(4.dp))

                        Text(
                            text = "및 이용 안내",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = pretendardFontFamily
                            )
                        )
                    }
                }
                Image(
                    painter = painterResource(Res.drawable.ic_notice),
                    contentDescription = "notice",
                    modifier = Modifier
                        .size(85.dp)
                )
            }
        }

        // 대체 노선 찾기 버튼
        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .border(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xffF1F1F1),
                            Color(0xffEBEBEB),
                        ),
                        start = Offset(1f, 0f),
                        end = Offset(0f, 1f)
                    ),
                    width = 1.dp,
                    shape = RoundedCornerShape(44.dp)
                )
                .boxShadow(
                    color = Color(0xff000000).copy(alpha = 0.2f),
                    offset = DpOffset(0.dp, 2.dp),
                    radius = 8.dp,
                    shape = RoundedCornerShape(44.dp)
                )
                .background(
                    brush = Brush.linearGradient(
                        colorStops = arrayOf(
                            0.38f to Color(0xffFFFFFF).copy(alpha = 0.55f),
                            0.80f to Color(0xffF1F1F1).copy(alpha = 0.55f),
                            1f to Color(0xffFFFFFF).copy(alpha = 0.55f),
                        ),
                        start = Offset.Zero,
                        end = Offset.Infinite
                    )
                )
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop92)
                    bottom.linkTo(guidelineTop98)
                    end.linkTo(parent.end)
                }
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_magnify),
                    contentDescription = "notice",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = "대체 노선 찾기",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = pretendardFontFamily
                    )
                )
            }
        }
    }
}