package com.ohanahana.cloudcompute.screens.projectinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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

@Composable
fun SensorOperationTimeScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val guidelineTop07 = createGuidelineFromTop(0.07f)
        val guidelineTop09 = createGuidelineFromTop(0.09f)

        val (
            headerRef,
            boxLabelRef,
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

            LoadImage(
                "ic_arrow",
                "ic_arrow",
                Modifier.align(Alignment.CenterStart).clickable { navController.navigateUp() })

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

        //이용 안내
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
                text = "이용 안내",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))
            Text(
                text = "센서 작동 시간",
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
                .constrainAs(createRef()) {
                    top.linkTo(boxLabelRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = buildAnnotatedString {
                    append("센서 작동 시간은 평일 ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("10:00~21:00")
                    }
                    append("입니다.")
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

        }
    }
}