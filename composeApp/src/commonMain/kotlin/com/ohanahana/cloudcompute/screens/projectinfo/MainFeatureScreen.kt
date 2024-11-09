package com.ohanahana.cloudcompute.screens.projectinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.ohanahana.cloudcompute.LoadImage
import com.ohanahana.cloudcompute.pretendardFontFamily
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.ic_congestion
import kmp_app_template.composeapp.generated.resources.ic_leisure
import kmp_app_template.composeapp.generated.resources.ic_normal
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainFeatureScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val guidelineTop07 = createGuidelineFromTop(0.07f)
        val guidelineTop09 = createGuidelineFromTop(0.09f)

        val (
            headerRef,
            boxLabelRef,
            boxLabelExplainRef,
            boxFeatureCheckRef,
        ) = createRefs()

        // 헤더
        Box(
            modifier = Modifier
                .constrainAs(headerRef) {
                    top.linkTo(guidelineTop07)
                    bottom.linkTo(guidelineTop09)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .background(Color(0xffFEFEFE))
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)) {

            LoadImage("ic_arrow", "ic_arrow", Modifier.align(Alignment.CenterStart).clickable { navController.navigateUp() })

            Text(
                text = "프로젝트 소개 및 이용 안내",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        //프로젝트 소개
        Column(
            modifier = Modifier
                .constrainAs(boxLabelRef) {
                    top.linkTo(headerRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "프로젝트 소개",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))
            Text(
                text = "주요 기능",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "2024.10.28",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color(0xff666666),
            )
        }

        Divider(
            color = Color(0xffF1F1F1),
            thickness = 1.dp,
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(boxLabelRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(horizontal = 24.dp)

        )

        //프로젝트 설명
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = 24.dp)
                .constrainAs(boxLabelExplainRef) {
                    top.linkTo(boxLabelRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "해당 프로젝트는 '23-2 클라우드 컴퓨팅' 수업에서 6명의 팀원과 함께 제\n작했습니다.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "  • 개발: 김동환, 김준석, 박지운, 부준혁, 임준우, 조성민",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "  • 디자인: 주서윤",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
        }

        //실시간 대기줄 상태 확인
        Column(
            modifier = Modifier
                .padding(top= 24.dp)
                .padding(horizontal = 24.dp)
                .constrainAs(boxFeatureCheckRef) {
                    top.linkTo(boxLabelExplainRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "실시간 대기줄 상태 확인",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))
            Text(
                text = buildAnnotatedString {
                    append("후문 정류장 511번 버스 대기줄 혼잡도를 ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("여유, ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("보통, ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("혼잡")
                    }
                    append(" 세 단계로 확인할 수 있습니다.")
                },
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
            Spacer(Modifier.height(12.dp))

            Row(
                Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_leisure),
                    contentDescription = "ic_leisure",
                )
                Image(
                    painter = painterResource(Res.drawable.ic_normal),
                    contentDescription = "ic_normal",
                )
                Image(
                    painter = painterResource(Res.drawable.ic_congestion),
                    contentDescription = "ic_congestion",
                )
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "다른 노선 정보 제공",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "주안역으로 가는 다양한 노선 정보를 확인할 수 있습니다.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "학교 셔틀버스 포함",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
        }

    }
}

