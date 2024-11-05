package com.ohana.cloudcompute.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import kmp_app_template.composeapp.generated.resources.ic_arrival
import kmp_app_template.composeapp.generated.resources.ic_departure
import kmp_app_template.composeapp.generated.resources.ic_shuttle
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BusInfoScreen(navController: NavController) {

    //val busData = TestBusData()
    val viewModel: BusViewModel = koinViewModel()
    val busData by viewModel.busData.collectAsState()

    Column(Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .background(Color(0xffFEFEFE))
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            LoadImage(
                "ic_arrow",
                "ic_arrow",
                Modifier.align(Alignment.CenterStart).clickable { navController.navigateUp() }
            )

            Text(
                text = "대체 노선 찾기",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )

            LoadImage("ic_refresh", "ic_refresh", Modifier.align(Alignment.CenterEnd).clickable { viewModel.fetchBusData() })
        }
        Spacer(Modifier.height(8.dp))

        LazyColumn {
            busData?.let { data ->
                println(data)
                items(
                    listOf(
                        data.shuttle,
                        data.ddg,
                        data.yg,
                        data.inhaFrontGate
                    )
                ) { busStop ->
                    val iconDeparture = if (busStop == data.shuttle) {
                        Res.drawable.ic_shuttle
                    } else {
                        Res.drawable.ic_departure
                    }
                    BusInfoCard(
                        iconDeparture = iconDeparture,
                        iconArrival = Res.drawable.ic_arrival,
                        textDeparture = busStop.busStopName,
                        textArrival = busStop.des,
                        remainTime = busStop.remainTime,
                        estimatedTime = busStop.estimatedTime,
                        busNumber = busStop.busNumber
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun BusInfoCard(
    iconDeparture: DrawableResource,
    iconArrival: DrawableResource,
    textDeparture: String,
    textArrival: String,
    remainTime: Int,
    estimatedTime: Int,
    busNumber: String
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .boxShadow(
                color = Color(0xff793ACC).copy(alpha = 0.1f),
                offset = DpOffset(0.dp, 2.dp),
                radius = 1.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .background(Color(0xffFEFEFE))
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp)
    ) {
        val (
            labelExpectedTimeRef,
            expectedTimeRef,
            labelMinuteRef,
            verticalDividerRef,
            horizontalDividerRef,
            iconDepartureRef,
            textDepartureRef,
            iconArrivalRef,
            busNumberRef,
        ) = createRefs()

        Text(
            text = "예상 소요 시간",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = pretendardFontFamily
            ),
            color = Color(0xff666666),
            modifier = Modifier
                .constrainAs(labelExpectedTimeRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(start = 8.dp)
                .padding(top = 20.dp)
        )

        Text(
            text = estimatedTime.toString(),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = pretendardFontFamily
            ),
            color = Color.Black,
            modifier = Modifier
                .constrainAs(expectedTimeRef) {
                    top.linkTo(labelExpectedTimeRef.bottom)
                    start.linkTo(labelExpectedTimeRef.start)
                }
                .padding(top = 4.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = " 분",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = pretendardFontFamily
            ),
            color = Color.Black,
            modifier = Modifier
                .constrainAs(labelMinuteRef) {
                    bottom.linkTo(expectedTimeRef.bottom)
                    start.linkTo(expectedTimeRef.end)
                }
                .padding(bottom = 4.dp)
        )


        Divider(
            color = Color(0xffEBEBEB),
            thickness = 1.dp,
            modifier = Modifier
                .constrainAs(horizontalDividerRef) {
                    top.linkTo(expectedTimeRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        )

        Image(
            painter = painterResource(iconDeparture),
            contentDescription = "ic_shuttle",
            Modifier
                .constrainAs(iconDepartureRef) {
                    top.linkTo(horizontalDividerRef.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 2.dp)
        )

        Divider(
            color = Color(0xffEBEBEB),
            thickness = 1.dp,
            modifier = Modifier
                .constrainAs(verticalDividerRef) {
                    top.linkTo(iconDepartureRef.bottom)
                    start.linkTo(iconDepartureRef.start)
                    end.linkTo(iconDepartureRef.end)
                }
                .height(40.dp)
                .width(1.dp)
                .padding(vertical = 4.dp)
        )

        Image(
            painter = painterResource(iconArrival),
            contentDescription = "ic_arrival",
            Modifier
                .constrainAs(iconArrivalRef) {
                    top.linkTo(verticalDividerRef.bottom)
                    start.linkTo(iconDepartureRef.start)
                    end.linkTo(iconDepartureRef.end)
                }
                .padding(start = 2.dp)
        )

        Text(
            text = textDeparture,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = pretendardFontFamily
            ),
            color = Color.Black,
            modifier = Modifier
                .padding(start = 12.dp)
                .constrainAs(textDepartureRef) {
                    top.linkTo(iconDepartureRef.top)
                    bottom.linkTo(iconDepartureRef.bottom)
                    start.linkTo(iconDepartureRef.end)
                }
        )

        Box(
            modifier = Modifier
                .padding(top = 1.dp)
                .padding(start = 12.dp)
                .constrainAs(busNumberRef) {
                    start.linkTo(textDepartureRef.start)
                    top.linkTo(iconDepartureRef.bottom)
                }
                .background(
                    color = Color(0xffC96FBF).copy(alpha = 0.2f),
                    shape = RoundedCornerShape(8.dp)
                )

                .padding(vertical = 4.dp, horizontal = 6.dp)
        ) {
            Text(
                text = busNumber,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xff42023B)
                )
            )
        }

        Text(
            text = "$remainTime" +"분 전",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffD61c1c)
            ),
            modifier = Modifier
                .padding(start = 8.dp)
                .constrainAs(createRef()) {
                    start.linkTo(busNumberRef.end)
                    top.linkTo(busNumberRef.top)
                    bottom.linkTo(busNumberRef.bottom)
                }
        )

        Text(
            text = textArrival,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            ),
            modifier = Modifier
                .padding(start = 12.dp)
                .constrainAs(createRef()) {
                    start.linkTo(iconArrivalRef.end)
                    top.linkTo(iconArrivalRef.top)
                    bottom.linkTo(iconArrivalRef.bottom)
                }
        )

    }
}

//data class TestBusData(
//    val shuttle: BusStopData = BusStopData(
//        busStopName = "교내 셔틀 승강장",
//        busStopNumber = "1",
//        busNumber = "셔틀",
//        remainTime = 10,
//        remainBusStop = 2,
//        congestion = 0,
//        des = "주안역",
//        estimatedTime = 15,
//        isTransfer = false
//    ),
//    val ddg: BusStopData = BusStopData(
//        busStopName = "독정이고개",
//        busStopNumber = "37234",
//        busNumber = "13",
//        remainTime = 5,
//        remainBusStop = 1,
//        congestion = 0,
//        des = "주안역",
//        estimatedTime = 10,
//        isTransfer = false
//    ),
//    val yg: BusStopData = BusStopData(
//        busStopName = "용현고가교",
//        busStopNumber = "37611",
//        busNumber = "511",
//        remainTime = 7,
//        remainBusStop = 0,
//        congestion = 1,
//        des = "주안역",
//        estimatedTime = 12,
//        isTransfer = false
//    ),
//    val inhaFrontGate: BusStopData = BusStopData(
//        busStopName = "인하대정문",
//        busStopNumber = "37099",
//        busNumber = "516",
//        remainTime = 8,
//        remainBusStop = 1,
//        congestion = 1,
//        des = "주안역",
//        estimatedTime = 15,
//        isTransfer = false
//    )
//)
//
//data class BusStopData(
//    val busStopName: String,
//    val busStopNumber: String?,
//    val busNumber: String,
//    val remainTime: Int,
//    val remainBusStop: Int,
//    val congestion: Int,
//    val des: String,
//    val estimatedTime: Int,
//    val isTransfer: Boolean
//)