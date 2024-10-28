package com.ohana.cloudcompute.screens.projectinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.ohana.cloudcompute.LoadImage
import com.ohana.cloudcompute.pretendardFontFamily
import io.github.kubode.compose.boxshadow.boxShadow
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.ic_notice
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectInfoScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .background(Color(0xffFEFEFE))
            .fillMaxSize()
    ) {
        val guidelineTop07 = createGuidelineFromTop(0.07f)
        val guidelineTop09 = createGuidelineFromTop(0.09f)
        val guidelineTop13 = createGuidelineFromTop(0.13f)
        val guidelineTop25 = createGuidelineFromTop(0.25f)
        val guidelineTop30 = createGuidelineFromTop(0.30f)

        val itemFirst = createRef()
        val itemSecond = createRef()
        val itemThird = createRef()
        val itemBottom = createRef()


        // 헤더
        Box(
            modifier = Modifier
                .constrainAs(createRef()) {
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

        //소개해드려요 박스
        Box(
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop13)
                    bottom.linkTo(guidelineTop25)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .boxShadow(
                    color = Color(0xff793ACC).copy(alpha = 0.1f),
                    offset = DpOffset(0.dp, 2.dp),
                    radius = 1.dp,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color(0xffFEFEFE))
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "오하나하나 앱에 대해\n소개해드려요!",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = pretendardFontFamily
                        ),
                        color = Color.Black,
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_notice),
                        contentDescription = "notice",
                        modifier = Modifier
                            .size(85.dp)
                    )
                }

            }
        }

        //항목 리스트
        ItemRow(
            titleSmall = "프로젝트 소개",
            titleLarge = "주요 기능",
            onClick = {
                navController.navigate("mainFeature")
            },
            modifier = Modifier.constrainAs(itemFirst) {
                top.linkTo(guidelineTop30)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        ItemRow(
            titleSmall = "이용 안내",
            titleLarge = "혼잡도 기준",
            onClick = {
                navController.navigate("congestionCriteria")
            },
            modifier = Modifier.constrainAs(itemSecond) {
                top.linkTo(itemFirst.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        ItemRow(
            titleSmall = "이용 안내",
            titleLarge = "예상 대기 인원 및 대기 시간",
            onClick = {
                navController.navigate("mainFeature")
            },
            modifier = Modifier.constrainAs(itemThird) {
                top.linkTo(itemSecond.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        ItemRow(
            titleSmall = "이용 안내",
            titleLarge = "센서 작동 시간",
            onClick = {
                navController.navigate("mainFeature")
            },
            modifier = Modifier.constrainAs(createRef()) {
                top.linkTo(itemThird.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Divider(
            color = Color(0xffF1F1F1),
            thickness = 1.dp,
            modifier = Modifier
                .constrainAs(createRef()) {
                    bottom.linkTo(itemBottom.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        //하단 버그 제보 및 문의
        Box(
            modifier = Modifier
                .constrainAs(itemBottom) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(bottom = 50.dp)
        ) {


            Row(
                modifier = Modifier
                    .padding(horizontal = 60.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "버그 제보 및 문의 | ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color(0xff666666),
                )
                Text(
                    text = "gourderased@gmail.com",
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
}

@Composable
fun ItemRow(
    titleSmall: String,
    titleLarge: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = titleSmall,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color(0xff666666),
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = titleLarge,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color.Black,
                )
            }
            LoadImage(
                "ic_line",
                "ic_line",
                Modifier.clickable { onClick() }
            )
        }
        Divider(
            color = Color(0xffF1F1F1),
            thickness = 1.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}
